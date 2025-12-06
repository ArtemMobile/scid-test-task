package com.example.scid_test_task.domain.repository

import com.example.scid_test_task.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    fun getAllFavorites(): Flow<List<Product>>
    suspend fun addToFavorites(product: Product)
    suspend fun removeFromFavorites(productId: Int)
    suspend fun isFavorite(productId: Int): Boolean
}