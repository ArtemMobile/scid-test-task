package com.example.scid_test_task.data.di;

@dagger.Module()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0005H\u0007\u00a8\u0006\r"}, d2 = {"Lcom/example/scid_test_task/data/di/DatabaseModule;", "", "<init>", "()V", "provideAppDatabase", "Lcom/example/scid_test_task/data/local/database/AppDatabase;", "context", "Landroid/content/Context;", "provideProductDao", "Lcom/example/scid_test_task/data/local/dao/ProductDao;", "database", "provideFavoriteDao", "Lcom/example/scid_test_task/data/local/dao/FavoriteDao;", "data_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.scid_test_task.data.di.DatabaseModule INSTANCE = null;
    
    private DatabaseModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.scid_test_task.data.local.database.AppDatabase provideAppDatabase(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.example.scid_test_task.data.local.dao.ProductDao provideProductDao(@org.jetbrains.annotations.NotNull()
    com.example.scid_test_task.data.local.database.AppDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.example.scid_test_task.data.local.dao.FavoriteDao provideFavoriteDao(@org.jetbrains.annotations.NotNull()
    com.example.scid_test_task.data.local.database.AppDatabase database) {
        return null;
    }
}