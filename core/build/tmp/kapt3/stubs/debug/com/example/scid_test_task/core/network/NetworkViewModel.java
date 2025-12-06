package com.example.scid_test_task.core.network;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/example/scid_test_task/core/network/NetworkViewModel;", "Lcom/example/scid_test_task/core/mvi/MVIViewModel;", "Lcom/example/scid_test_task/core/network/NetworkEvents;", "networkStateManager", "Lcom/example/scid_test_task/core/network/NetworkStateManager;", "<init>", "(Lcom/example/scid_test_task/core/network/NetworkStateManager;)V", "isOnlineMode", "Lkotlinx/coroutines/flow/StateFlow;", "", "()Lkotlinx/coroutines/flow/StateFlow;", "isNetworkAvailable", "doEvent", "", "event", "observeNetworkStatus", "toggleOnlineMode", "setOnlineMode", "enabled", "core_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class NetworkViewModel extends com.example.scid_test_task.core.mvi.MVIViewModel<com.example.scid_test_task.core.network.NetworkEvents> {
    @org.jetbrains.annotations.NotNull()
    private final com.example.scid_test_task.core.network.NetworkStateManager networkStateManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isOnlineMode = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isNetworkAvailable = null;
    
    @javax.inject.Inject()
    public NetworkViewModel(@org.jetbrains.annotations.NotNull()
    com.example.scid_test_task.core.network.NetworkStateManager networkStateManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isOnlineMode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isNetworkAvailable() {
        return null;
    }
    
    @java.lang.Override()
    public void doEvent(@org.jetbrains.annotations.NotNull()
    com.example.scid_test_task.core.network.NetworkEvents event) {
    }
    
    private final void observeNetworkStatus() {
    }
    
    private final void toggleOnlineMode() {
    }
    
    private final void setOnlineMode(boolean enabled) {
    }
}