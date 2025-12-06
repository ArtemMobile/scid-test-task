package com.example.scid_test_task.data.repository;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096@\u00a2\u0006\u0002\u0010\u0012J,\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@\u00a2\u0006\u0002\u0010\u0016J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0096@\u00a2\u0006\u0002\u0010\u001aJ$\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@\u00a2\u0006\u0002\u0010\u001cJ\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000e0\rH\u0096@\u00a2\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020 H\u0096@\u00a2\u0006\u0002\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/example/scid_test_task/data/repository/ProductRepositoryImpl;", "Lcom/example/scid_test_task/domain/repository/ProductRepository;", "api", "Lcom/example/scid_test_task/data/remote/api/FakeStoreApi;", "database", "Lcom/example/scid_test_task/data/local/database/AppDatabase;", "productDao", "Lcom/example/scid_test_task/data/local/dao/ProductDao;", "networkStateManager", "Lcom/example/scid_test_task/core/network/NetworkStateManager;", "<init>", "(Lcom/example/scid_test_task/data/remote/api/FakeStoreApi;Lcom/example/scid_test_task/data/local/database/AppDatabase;Lcom/example/scid_test_task/data/local/dao/ProductDao;Lcom/example/scid_test_task/core/network/NetworkStateManager;)V", "getProducts", "Lcom/example/scid_test_task/domain/util/Result;", "", "Lcom/example/scid_test_task/domain/model/Product;", "category", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadFromCache", "originalException", "", "(Ljava/lang/String;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProductById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadProductFromCache", "(ILjava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCategories", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshProducts", "", "data_debug"})
public final class ProductRepositoryImpl implements com.example.scid_test_task.domain.repository.ProductRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.scid_test_task.data.remote.api.FakeStoreApi api = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.scid_test_task.data.local.database.AppDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.scid_test_task.data.local.dao.ProductDao productDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.scid_test_task.core.network.NetworkStateManager networkStateManager = null;
    
    @javax.inject.Inject()
    public ProductRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.scid_test_task.data.remote.api.FakeStoreApi api, @org.jetbrains.annotations.NotNull()
    com.example.scid_test_task.data.local.database.AppDatabase database, @org.jetbrains.annotations.NotNull()
    com.example.scid_test_task.data.local.dao.ProductDao productDao, @org.jetbrains.annotations.NotNull()
    com.example.scid_test_task.core.network.NetworkStateManager networkStateManager) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getProducts(@org.jetbrains.annotations.Nullable()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.scid_test_task.domain.util.Result<? extends java.util.List<com.example.scid_test_task.domain.model.Product>>> $completion) {
        return null;
    }
    
    private final java.lang.Object loadFromCache(java.lang.String category, java.lang.Throwable originalException, kotlin.coroutines.Continuation<? super com.example.scid_test_task.domain.util.Result<? extends java.util.List<com.example.scid_test_task.domain.model.Product>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getProductById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.scid_test_task.domain.util.Result<com.example.scid_test_task.domain.model.Product>> $completion) {
        return null;
    }
    
    private final java.lang.Object loadProductFromCache(int id, java.lang.Throwable originalException, kotlin.coroutines.Continuation<? super com.example.scid_test_task.domain.util.Result<com.example.scid_test_task.domain.model.Product>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getCategories(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.scid_test_task.domain.util.Result<? extends java.util.List<java.lang.String>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object refreshProducts(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}