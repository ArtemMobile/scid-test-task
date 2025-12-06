package com.example.scid_test_task.core.network

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkStateManager @Inject constructor(
    val networkMonitor: NetworkMonitor
) {
    private val _isOnlineMode = MutableStateFlow(true)
    val isOnlineMode: StateFlow<Boolean> = _isOnlineMode.asStateFlow()

    private val _isNetworkAvailable = MutableStateFlow(networkMonitor.isCurrentlyOnline())
    val isNetworkAvailable: StateFlow<Boolean> = _isNetworkAvailable.asStateFlow()

    fun setOnlineMode(enabled: Boolean) {
        _isOnlineMode.value = enabled
    }

    fun toggleOnlineMode() {
        _isOnlineMode.value = !_isOnlineMode.value
    }

    fun updateNetworkAvailability(isAvailable: Boolean) {
        _isNetworkAvailable.value = isAvailable
    }

    fun shouldUseOnlineMode(): Boolean {
        return _isOnlineMode.value && _isNetworkAvailable.value
    }
}


