package com.example.scid_test_task.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.scid_test_task.data.local.dao.FavoriteDao
import com.example.scid_test_task.data.local.dao.ProductDao
import com.example.scid_test_task.data.local.entity.FavoriteEntity
import com.example.scid_test_task.data.local.entity.ProductEntity

@Database(
    entities = [ProductEntity::class, FavoriteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun favoriteDao(): FavoriteDao
}

