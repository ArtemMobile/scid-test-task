package com.example.scid_test_task.domain.repository

import androidx.paging.PagingData
import com.example.scid_test_task.domain.model.Product
import com.example.scid_test_task.domain.util.Result
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProducts(category: String? = null): Result<List<Product>>
    fun getProductsPaged(category: String? = null): Flow<PagingData<Product>>
    suspend fun getProductById(id: Int): Result<Product>
    suspend fun getCategories(): Result<List<String>>
}

