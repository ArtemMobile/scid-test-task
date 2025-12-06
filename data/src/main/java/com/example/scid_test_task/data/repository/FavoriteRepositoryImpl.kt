package com.example.scid_test_task.data.repository

import com.example.scid_test_task.data.local.dao.FavoriteDao
import com.example.scid_test_task.data.local.entity.FavoriteEntity
import com.example.scid_test_task.domain.model.Product
import com.example.scid_test_task.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(
    private val favoriteDao: FavoriteDao
) : FavoriteRepository {

    override fun getAllFavorites(): Flow<List<Product>> {
        return favoriteDao.getAllFavorites().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun addToFavorites(product: Product) {
        favoriteDao.insertFavorite(FavoriteEntity.fromDomain(product))
    }

    override suspend fun removeFromFavorites(productId: Int) {
        favoriteDao.deleteFavorite(productId)
    }

    override suspend fun isFavorite(productId: Int): Boolean {
        return favoriteDao.getFavoriteById(productId) != null
    }
}

