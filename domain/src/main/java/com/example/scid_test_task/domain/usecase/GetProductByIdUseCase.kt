package com.example.scid_test_task.domain.usecase

import com.example.scid_test_task.domain.model.Product
import com.example.scid_test_task.domain.repository.ProductRepository
import com.example.scid_test_task.domain.util.Result

class GetProductByIdUseCase(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(id: Int): Result<Product> {
        return repository.getProductById(id)
    }
}

