package com.example.scid_test_task.domain.di

import com.example.scid_test_task.domain.repository.FavoriteRepository
import com.example.scid_test_task.domain.repository.ProductRepository
import com.example.scid_test_task.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetProductsUseCase(
        repository: ProductRepository
    ): GetProductsUseCase {
        return GetProductsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetProductByIdUseCase(
        repository: ProductRepository
    ): GetProductByIdUseCase {
        return GetProductByIdUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetCategoriesUseCase(
        repository: ProductRepository
    ): GetCategoriesUseCase {
        return GetCategoriesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideAddToFavoritesUseCase(
        repository: FavoriteRepository
    ): AddToFavoritesUseCase {
        return AddToFavoritesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideRemoveFromFavoritesUseCase(
        repository: FavoriteRepository
    ): RemoveFromFavoritesUseCase {
        return RemoveFromFavoritesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetFavoritesUseCase(
        repository: FavoriteRepository
    ): GetFavoritesUseCase {
        return GetFavoritesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideIsFavoriteUseCase(
        repository: FavoriteRepository
    ): IsFavoriteUseCase {
        return IsFavoriteUseCase(repository)
    }
}

