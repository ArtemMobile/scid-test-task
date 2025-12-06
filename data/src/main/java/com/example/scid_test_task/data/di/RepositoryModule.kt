package com.example.scid_test_task.data.di

import com.example.scid_test_task.data.local.dao.FavoriteDao
import com.example.scid_test_task.data.local.dao.ProductDao
import com.example.scid_test_task.data.local.database.AppDatabase
import com.example.scid_test_task.core.network.NetworkStateManager
import com.example.scid_test_task.data.remote.api.FakeStoreApi
import com.example.scid_test_task.data.repository.FavoriteRepositoryImpl
import com.example.scid_test_task.data.repository.ProductRepositoryImpl
import com.example.scid_test_task.domain.repository.FavoriteRepository
import com.example.scid_test_task.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideProductRepository(
        api: FakeStoreApi,
        database: AppDatabase,
        productDao: ProductDao,
        networkStateManager: NetworkStateManager
    ): ProductRepository {
        return ProductRepositoryImpl(api, database, productDao, networkStateManager)
    }

    @Provides
    @Singleton
    fun provideFavoriteRepository(
        favoriteDao: FavoriteDao
    ): FavoriteRepository {
        return FavoriteRepositoryImpl(favoriteDao)
    }
}

