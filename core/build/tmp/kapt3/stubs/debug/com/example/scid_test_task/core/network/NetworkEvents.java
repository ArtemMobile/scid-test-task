package com.example.scid_test_task.core.network;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/scid_test_task/core/network/NetworkEvents;", "Lcom/example/scid_test_task/core/mvi/Events;", "<init>", "()V", "ToggleOnlineMode", "SetOnlineMode", "Lcom/example/scid_test_task/core/network/NetworkEvents$SetOnlineMode;", "Lcom/example/scid_test_task/core/network/NetworkEvents$ToggleOnlineMode;", "core_debug"})
public abstract class NetworkEvents implements com.example.scid_test_task.core.mvi.Events {
    
    private NetworkEvents() {
        super();
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/example/scid_test_task/core/network/NetworkEvents$SetOnlineMode;", "Lcom/example/scid_test_task/core/network/NetworkEvents;", "enabled", "", "<init>", "(Z)V", "getEnabled", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_debug"})
    public static final class SetOnlineMode extends com.example.scid_test_task.core.network.NetworkEvents {
        private final boolean enabled = false;
        
        public SetOnlineMode(boolean enabled) {
        }
        
        public final boolean getEnabled() {
            return false;
        }
        
        public final boolean component1() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.scid_test_task.core.network.NetworkEvents.SetOnlineMode copy(boolean enabled) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/scid_test_task/core/network/NetworkEvents$ToggleOnlineMode;", "Lcom/example/scid_test_task/core/network/NetworkEvents;", "<init>", "()V", "core_debug"})
    public static final class ToggleOnlineMode extends com.example.scid_test_task.core.network.NetworkEvents {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.scid_test_task.core.network.NetworkEvents.ToggleOnlineMode INSTANCE = null;
        
        private ToggleOnlineMode() {
        }
    }
}