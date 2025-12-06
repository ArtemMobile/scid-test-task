package com.example.scid_test_task.core.network

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NetworkViewModel @Inject constructor(
    private val networkStateManager: NetworkStateManager
) : ViewModel() {

    val isOnlineMode: StateFlow<Boolean> = networkStateManager.isOnlineMode
    val isNetworkAvailable: StateFlow<Boolean> = networkStateManager.isNetworkAvailable

    init {
        observeNetworkStatus()
    }

    private fun observeNetworkStatus() {
        viewModelScope.launch {
            networkStateManager.networkMonitor.isOnline.collect { isOnline ->
                networkStateManager.updateNetworkAvailability(isOnline)
            }
        }
    }
}

