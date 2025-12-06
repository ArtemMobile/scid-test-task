package com.example.scid_test_task.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.room.withTransaction
import com.example.scid_test_task.core.network.NetworkStateManager
import com.example.scid_test_task.data.local.dao.ProductDao
import com.example.scid_test_task.data.local.database.AppDatabase
import com.example.scid_test_task.data.local.entity.ProductEntity
import com.example.scid_test_task.data.remote.api.FakeStoreApi
import com.example.scid_test_task.data.remote.dto.ProductDto
import com.example.scid_test_task.domain.model.Product

class ProductsPagingSource(
    private val api: FakeStoreApi,
    private val productDao: ProductDao,
    private val database: AppDatabase,
    private val networkStateManager: NetworkStateManager,
    private val category: String?
) : PagingSource<Int, Product>() {

    private var cachedProducts: List<Product>? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        return try {
            if (cachedProducts == null) {
                val shouldUseOnline = networkStateManager.shouldUseOnlineMode()
                
                cachedProducts = if (shouldUseOnline) {
                    try {
                        val products: List<ProductDto> = if (category != null) {
                            api.getProductsByCategory(
                                category = category,
                                limit = 10000
                            )
                        } else {
                            api.getProducts(limit = 10000)
                        }
                        
                        val domainProducts = products
                            .map { it.toDomain() }
                            .distinctBy { it.id }
                        
                        database.withTransaction {
                            if (category != null) {
                                productDao.clearProductsByCategory(category)
                            } else {
                                productDao.clearProducts()
                            }
                            productDao.insertProducts(domainProducts.map { ProductEntity.fromDomain(it) })
                        }
                        
                        domainProducts
                    } catch (e: Exception) {
                        loadFromDatabase()
                    }
                } else {
                    loadFromDatabase()
                }
            }

            val allProducts = cachedProducts ?: emptyList()
            
            val startIndex = params.key ?: 0
            val pageSize = params.loadSize
            
            if (startIndex >= allProducts.size) {
                return LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
            
            val endIndex = (startIndex + pageSize).coerceAtMost(allProducts.size)
            val pageProducts = allProducts.subList(startIndex, endIndex)

            LoadResult.Page(
                data = pageProducts,
                prevKey = if (startIndex == 0) null else (startIndex - pageSize).coerceAtLeast(0),
                nextKey = if (endIndex >= allProducts.size) null else endIndex
            )
        } catch (e: Exception) {
            try {
                val dbProducts = loadFromDatabase()
                if (dbProducts.isNotEmpty()) {
                    cachedProducts = dbProducts
                    val startIndex = params.key ?: 0
                    val pageSize = params.loadSize
                    val endIndex = (startIndex + pageSize).coerceAtMost(dbProducts.size)
                    val pageProducts = dbProducts.subList(startIndex, endIndex.coerceAtMost(dbProducts.size))
                    
                    LoadResult.Page(
                        data = pageProducts,
                        prevKey = if (startIndex == 0) null else (startIndex - pageSize).coerceAtLeast(0),
                        nextKey = if (endIndex >= dbProducts.size) null else endIndex
                    )
                } else {
                    LoadResult.Error(e)
                }
            } catch (dbException: Exception) {
                LoadResult.Error(e)
            }
        }
    }

    private suspend fun loadFromDatabase(): List<Product> {
        val cachedProducts = if (category != null) {
            productDao.getProductsByCategory(category)
        } else {
            productDao.getAllProductsList()
        }
        return cachedProducts.map { it.toDomain() }.distinctBy { it.id }
    }

    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        cachedProducts = null
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}

