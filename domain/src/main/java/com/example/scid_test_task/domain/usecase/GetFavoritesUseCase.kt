package com.example.scid_test_task.domain.usecase

import com.example.scid_test_task.domain.model.Product
import com.example.scid_test_task.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow

class GetFavoritesUseCase(
    private val repository: FavoriteRepository
) {
    operator fun invoke(): Flow<List<Product>> {
        return repository.getAllFavorites()
    }
}

