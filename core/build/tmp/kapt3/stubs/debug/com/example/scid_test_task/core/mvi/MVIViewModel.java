package com.example.scid_test_task.core.mvi;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/example/scid_test_task/core/mvi/MVIViewModel;", "E", "Lcom/example/scid_test_task/core/mvi/Events;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "doEvent", "", "event", "(Lcom/example/scid_test_task/core/mvi/Events;)V", "core_debug"})
public abstract class MVIViewModel<E extends com.example.scid_test_task.core.mvi.Events> extends androidx.lifecycle.ViewModel {
    
    public MVIViewModel() {
        super();
    }
    
    public abstract void doEvent(@org.jetbrains.annotations.NotNull()
    E event);
}