package com.example.scid_test_task.domain.usecase

import com.example.scid_test_task.domain.repository.ProductRepository
import com.example.scid_test_task.domain.util.Result

class GetCategoriesUseCase(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(): Result<List<String>> {
        return repository.getCategories()
    }
}

