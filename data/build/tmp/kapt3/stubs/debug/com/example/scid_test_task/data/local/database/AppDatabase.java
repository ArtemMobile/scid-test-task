package com.example.scid_test_task.data.local.database;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/example/scid_test_task/data/local/database/AppDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "productDao", "Lcom/example/scid_test_task/data/local/dao/ProductDao;", "favoriteDao", "Lcom/example/scid_test_task/data/local/dao/FavoriteDao;", "data_debug"})
@androidx.room.Database(entities = {com.example.scid_test_task.data.local.entity.ProductEntity.class, com.example.scid_test_task.data.local.entity.FavoriteEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.scid_test_task.data.local.dao.ProductDao productDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.scid_test_task.data.local.dao.FavoriteDao favoriteDao();
}