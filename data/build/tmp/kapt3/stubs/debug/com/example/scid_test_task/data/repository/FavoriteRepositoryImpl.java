package com.example.scid_test_task.data.repository;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0016J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0096@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/scid_test_task/data/repository/FavoriteRepositoryImpl;", "Lcom/example/scid_test_task/domain/repository/FavoriteRepository;", "favoriteDao", "Lcom/example/scid_test_task/data/local/dao/FavoriteDao;", "<init>", "(Lcom/example/scid_test_task/data/local/dao/FavoriteDao;)V", "getAllFavorites", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/scid_test_task/domain/model/Product;", "addToFavorites", "", "product", "(Lcom/example/scid_test_task/domain/model/Product;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeFromFavorites", "productId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isFavorite", "", "data_debug"})
public final class FavoriteRepositoryImpl implements com.example.scid_test_task.domain.repository.FavoriteRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.scid_test_task.data.local.dao.FavoriteDao favoriteDao = null;
    
    @javax.inject.Inject()
    public FavoriteRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.scid_test_task.data.local.dao.FavoriteDao favoriteDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.example.scid_test_task.domain.model.Product>> getAllFavorites() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object addToFavorites(@org.jetbrains.annotations.NotNull()
    com.example.scid_test_task.domain.model.Product product, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object removeFromFavorites(int productId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object isFavorite(int productId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
}