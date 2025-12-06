package com.example.scid_test_task.domain.usecase

import com.example.scid_test_task.domain.model.Product
import com.example.scid_test_task.domain.repository.ProductRepository
import com.example.scid_test_task.domain.util.Result

class GetProductsUseCase(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(category: String? = null): Result<List<Product>> {
        return repository.getProducts(category)
    }
}

