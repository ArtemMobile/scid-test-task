package com.example.scid_test_task.domain.usecase

import com.example.scid_test_task.domain.repository.FavoriteRepository

class IsFavoriteUseCase(
    private val repository: FavoriteRepository
) {
    suspend operator fun invoke(productId: Int): Boolean {
        return repository.isFavorite(productId)
    }
}

