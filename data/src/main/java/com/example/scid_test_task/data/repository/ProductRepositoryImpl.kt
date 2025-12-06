package com.example.scid_test_task.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.room.withTransaction
import com.example.scid_test_task.data.local.dao.ProductDao
import com.example.scid_test_task.data.local.database.AppDatabase
import com.example.scid_test_task.data.local.entity.ProductEntity
import com.example.scid_test_task.core.network.NetworkStateManager
import com.example.scid_test_task.data.paging.ProductsPagingSource
import com.example.scid_test_task.data.remote.api.FakeStoreApi
import com.example.scid_test_task.domain.model.Product
import com.example.scid_test_task.domain.repository.ProductRepository
import com.example.scid_test_task.domain.util.Result
import kotlinx.coroutines.flow.Flow
import java.io.IOException
import retrofit2.HttpException
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: FakeStoreApi,
    private val database: AppDatabase,
    private val productDao: ProductDao,
    private val networkStateManager: NetworkStateManager
) : ProductRepository {

    override suspend fun getProducts(category: String?): Result<List<Product>> {
        if (!networkStateManager.shouldUseOnlineMode()) {
            return loadFromCache(category, Exception("Режим offline"))
        }

        return try {
            val products = if (category != null) {
                api.getProductsByCategory(category = category)
            } else {
                api.getProducts()
            }

            val domainProducts = products.map { it.toDomain() }

            database.withTransaction {
                if (category != null) {
                    productDao.clearProductsByCategory(category)
                } else {
                    productDao.clearProducts()
                }
                productDao.insertProducts(domainProducts.map { ProductEntity.fromDomain(it) })
            }

            Result.Success(domainProducts)
        } catch (e: Exception) {
            loadFromCache(category, e)
        }
    }

    private suspend fun loadFromCache(
        category: String?,
        originalException: Throwable
    ): Result<List<Product>> {
        return try {
            val cachedProducts = if (category != null) {
                productDao.getProductsByCategory(category)
            } else {
                productDao.getAllProductsList()
            }
            val domainProducts = cachedProducts.map { it.toDomain() }
            if (domainProducts.isEmpty()) {
                Result.Error(originalException, "Нет подключения к интернету и нет данных в кеше")
            } else {
                Result.Success(domainProducts)
            }
        } catch (e: Exception) {
            Result.Error(originalException, "Ошибка загрузки данных: ${e.message}")
        }
    }

    override suspend fun getProductById(id: Int): Result<Product> {
        if (!networkStateManager.shouldUseOnlineMode()) {
            return loadProductFromCache(id, Exception("Режим offline"))
        }

        return try {
            val productDto = api.getProductById(id)
            val domainProduct = productDto.toDomain()

            database.withTransaction {
                productDao.insertProducts(listOf(ProductEntity.fromDomain(domainProduct)))
            }

            Result.Success(domainProduct)
        } catch (e: Exception) {
            loadProductFromCache(id, e)
        }
    }

    private suspend fun loadProductFromCache(
        id: Int,
        originalException: Throwable
    ): Result<Product> {
        return try {
            val cachedProduct = productDao.getProductById(id)?.toDomain()
            if (cachedProduct == null) {
                Result.Error(
                    originalException,
                    "Товар не найден. Нет подключения к интернету и нет данных в кеше"
                )
            } else {
                Result.Success(cachedProduct)
            }
        } catch (e: Exception) {
            Result.Error(originalException, "Ошибка загрузки товара: ${e.message}")
        }
    }

    override suspend fun getCategories(): Result<List<String>> {
        if (!networkStateManager.shouldUseOnlineMode()) {
            return try {
                val cachedCategories = productDao.getCategories()
                if (cachedCategories.isEmpty()) {
                    Result.Error(Exception("Режим offline"), "Нет данных в кеше")
                } else {
                    Result.Success(cachedCategories)
                }
            } catch (e: Exception) {
                Result.Error(e, "Ошибка загрузки категорий: ${e.message}")
            }
        }

        return try {
            val categories = api.getCategories()
            Result.Success(categories)
        } catch (e: IOException) {
            try {
                val cachedCategories = productDao.getCategories()
                if (cachedCategories.isEmpty()) {
                    Result.Error(e, "Нет подключения к интернету и нет данных в кеше")
                } else {
                    Result.Success(cachedCategories)
                }
            } catch (ex: Exception) {
                Result.Error(e, "Ошибка загрузки категорий: ${ex.message}")
            }
        } catch (e: HttpException) {
            try {
                val cachedCategories = productDao.getCategories()
                if (cachedCategories.isEmpty()) {
                    Result.Error(e, "Ошибка сервера и нет данных в кеше")
                } else {
                    Result.Success(cachedCategories)
                }
            } catch (ex: Exception) {
                Result.Error(e, "Ошибка загрузки категорий: ${ex.message}")
            }
        } catch (e: Exception) {
            Result.Error(e, "Ошибка загрузки категорий: ${e.message}")
        }
    }

    override fun getProductsPaged(category: String?): Flow<PagingData<Product>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 10,
                prefetchDistance = 5
            ),
            pagingSourceFactory = {
                ProductsPagingSource(
                    api = api,
                    productDao = productDao,
                    database = database,
                    networkStateManager = networkStateManager,
                    category = category
                )
            }
        ).flow
    }
}

