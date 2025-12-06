package com.example.scid_test_task.data.di;

@dagger.Module()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/example/scid_test_task/data/di/RepositoryModule;", "", "<init>", "()V", "provideProductRepository", "Lcom/example/scid_test_task/domain/repository/ProductRepository;", "api", "Lcom/example/scid_test_task/data/remote/api/FakeStoreApi;", "database", "Lcom/example/scid_test_task/data/local/database/AppDatabase;", "productDao", "Lcom/example/scid_test_task/data/local/dao/ProductDao;", "networkStateManager", "Lcom/example/scid_test_task/core/network/NetworkStateManager;", "provideFavoriteRepository", "Lcom/example/scid_test_task/domain/repository/FavoriteRepository;", "favoriteDao", "Lcom/example/scid_test_task/data/local/dao/FavoriteDao;", "data_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class RepositoryModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.scid_test_task.data.di.RepositoryModule INSTANCE = null;
    
    private RepositoryModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.scid_test_task.domain.repository.ProductRepository provideProductRepository(@org.jetbrains.annotations.NotNull()
    com.example.scid_test_task.data.remote.api.FakeStoreApi api, @org.jetbrains.annotations.NotNull()
    com.example.scid_test_task.data.local.database.AppDatabase database, @org.jetbrains.annotations.NotNull()
    com.example.scid_test_task.data.local.dao.ProductDao productDao, @org.jetbrains.annotations.NotNull()
    com.example.scid_test_task.core.network.NetworkStateManager networkStateManager) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.scid_test_task.domain.repository.FavoriteRepository provideFavoriteRepository(@org.jetbrains.annotations.NotNull()
    com.example.scid_test_task.data.local.dao.FavoriteDao favoriteDao) {
        return null;
    }
}