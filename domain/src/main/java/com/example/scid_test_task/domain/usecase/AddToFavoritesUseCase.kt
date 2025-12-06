package com.example.scid_test_task.domain.usecase

import com.example.scid_test_task.domain.model.Product
import com.example.scid_test_task.domain.repository.FavoriteRepository

class AddToFavoritesUseCase(
    private val repository: FavoriteRepository
) {
    suspend operator fun invoke(product: Product) {
        repository.addToFavorites(product)
    }
}

