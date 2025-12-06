package com.example.scid_test_task.domain.repository

import com.example.scid_test_task.domain.model.Product
import com.example.scid_test_task.domain.util.Result

interface ProductRepository {
    suspend fun getProducts(category: String? = null): Result<List<Product>>
    suspend fun getProductById(id: Int): Result<Product>
    suspend fun getCategories(): Result<List<String>>
    suspend fun refreshProducts()
}

