package com.example.scid_test_task.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.scid_test_task.data.local.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Query("SELECT COUNT(*) FROM products WHERE category = :category")
    suspend fun getProductCountByCategory(category: String): Int

    @Query("SELECT * FROM products WHERE id = :id")
    suspend fun getProductById(id: Int): ProductEntity?

    @Query("SELECT DISTINCT category FROM products")
    suspend fun getCategories(): List<String>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(products: List<ProductEntity>)

    @Query("DELETE FROM products")
    suspend fun clearProducts()
    
    @Query("DELETE FROM products WHERE category = :category")
    suspend fun clearProductsByCategory(category: String)

    @Query("SELECT * FROM products ORDER BY timestamp DESC")
    suspend fun getAllProductsList(): List<ProductEntity>
    
    @Query("SELECT * FROM products WHERE category = :category ORDER BY timestamp DESC")
    suspend fun getProductsByCategory(category: String): List<ProductEntity>
}

