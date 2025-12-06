package com.example.scid_test_task.core.network

import com.example.scid_test_task.core.mvi.Events

sealed class NetworkEvents : Events {
    data class SetOnlineMode(val enabled: Boolean) : NetworkEvents()
}


