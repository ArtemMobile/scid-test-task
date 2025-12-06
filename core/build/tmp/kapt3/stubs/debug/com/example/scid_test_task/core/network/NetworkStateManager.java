package com.example.scid_test_task.core.network;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nJ\u0006\u0010\u0013\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/example/scid_test_task/core/network/NetworkStateManager;", "", "networkMonitor", "Lcom/example/scid_test_task/core/network/NetworkMonitor;", "<init>", "(Lcom/example/scid_test_task/core/network/NetworkMonitor;)V", "getNetworkMonitor", "()Lcom/example/scid_test_task/core/network/NetworkMonitor;", "_isOnlineMode", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isOnlineMode", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "_isNetworkAvailable", "isNetworkAvailable", "updateNetworkAvailability", "", "isAvailable", "shouldUseOnlineMode", "core_debug"})
public final class NetworkStateManager {
    @org.jetbrains.annotations.NotNull()
    private final com.example.scid_test_task.core.network.NetworkMonitor networkMonitor = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isOnlineMode = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isOnlineMode = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isNetworkAvailable = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isNetworkAvailable = null;
    
    @javax.inject.Inject()
    public NetworkStateManager(@org.jetbrains.annotations.NotNull()
    com.example.scid_test_task.core.network.NetworkMonitor networkMonitor) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.scid_test_task.core.network.NetworkMonitor getNetworkMonitor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isOnlineMode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isNetworkAvailable() {
        return null;
    }
    
    public final void updateNetworkAvailability(boolean isAvailable) {
    }
    
    public final boolean shouldUseOnlineMode() {
        return false;
    }
}