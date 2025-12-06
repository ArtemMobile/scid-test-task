package com.example.scid_test_task.core.mvi

import androidx.lifecycle.ViewModel

abstract class MVIViewModel<E : Events> : ViewModel() {
    abstract fun doEvent(event: E)
}



