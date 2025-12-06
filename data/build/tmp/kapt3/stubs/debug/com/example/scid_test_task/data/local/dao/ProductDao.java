package com.example.scid_test_task.data.local.dao;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\'J\u000e\u0010\b\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u00a7@\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u00a7@\u00a2\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u000bJ$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ,\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u001cJ\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u00a7@\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\u001f\u00c0\u0006\u0003"}, d2 = {"Lcom/example/scid_test_task/data/local/dao/ProductDao;", "", "getAllProducts", "Landroidx/paging/PagingSource;", "", "Lcom/example/scid_test_task/data/local/entity/ProductEntity;", "category", "", "getProductCount", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProductCountByCategory", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProductById", "id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCategories", "", "insertProducts", "", "products", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearProducts", "clearProductsByCategory", "getProductsPaged", "limit", "offset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProductsByCategoryPaged", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllProductsList", "getProductsByCategory", "data_debug"})
@androidx.room.Dao()
public abstract interface ProductDao {
    
    @androidx.room.Query(value = "SELECT * FROM products WHERE (:category IS NULL OR category = :category) ORDER BY timestamp DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.paging.PagingSource<java.lang.Integer, com.example.scid_test_task.data.local.entity.ProductEntity> getAllProducts(@org.jetbrains.annotations.Nullable()
    java.lang.String category);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM products")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getProductCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM products WHERE category = :category")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getProductCountByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM products WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getProductById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.scid_test_task.data.local.entity.ProductEntity> $completion);
    
    @androidx.room.Query(value = "SELECT DISTINCT category FROM products")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCategories(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertProducts(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.scid_test_task.data.local.entity.ProductEntity> products, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM products")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object clearProducts(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM products WHERE category = :category")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object clearProductsByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM products ORDER BY timestamp DESC LIMIT :limit OFFSET :offset")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getProductsPaged(int limit, int offset, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.scid_test_task.data.local.entity.ProductEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM products WHERE category = :category ORDER BY timestamp DESC LIMIT :limit OFFSET :offset")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getProductsByCategoryPaged(@org.jetbrains.annotations.NotNull()
    java.lang.String category, int limit, int offset, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.scid_test_task.data.local.entity.ProductEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM products ORDER BY timestamp DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllProductsList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.scid_test_task.data.local.entity.ProductEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM products WHERE category = :category ORDER BY timestamp DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getProductsByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.scid_test_task.data.local.entity.ProductEntity>> $completion);
}