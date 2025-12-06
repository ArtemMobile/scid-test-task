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
    // *
    @Query("SELECT * FROM products WHERE (:category IS NULL OR category = :category) ORDER BY timestamp DESC")
//    @Query("SELECT id,title,price,description,category,image,ratingRate,ratingCount,timestamp FROM products WHERE (:category IS NULL OR category = :category) ORDER BY timestamp DESC")
    fun getAllProducts(category: String?): PagingSource<Int, ProductEntity>

    // *
    @Query("SELECT COUNT(*) FROM products")
//    @Query("SELECT COUNT(id) FROM products")
    suspend fun getProductCount(): Int

    // *
    @Query("SELECT COUNT(*) FROM products WHERE category = :category")
//    @Query("SELECT COUNT(id) FROM products WHERE category = :category")
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
    
    @Query("SELECT * FROM products ORDER BY timestamp DESC LIMIT :limit OFFSET :offset")
    suspend fun getProductsPaged(limit: Int, offset: Int): List<ProductEntity>
    
    @Query("SELECT * FROM products WHERE category = :category ORDER BY timestamp DESC LIMIT :limit OFFSET :offset")
    suspend fun getProductsByCategoryPaged(category: String, limit: Int, offset: Int): List<ProductEntity>
    
    @Query("SELECT * FROM products ORDER BY timestamp DESC")
    suspend fun getAllProductsList(): List<ProductEntity>
    
    @Query("SELECT * FROM products WHERE category = :category ORDER BY timestamp DESC")
    suspend fun getProductsByCategory(category: String): List<ProductEntity>
}

