package com.example.scid_test_task.core.network

import androidx.lifecycle.viewModelScope
import com.example.scid_test_task.core.mvi.MVIViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NetworkViewModel @Inject constructor(
    private val networkStateManager: NetworkStateManager
) : MVIViewModel<NetworkEvents>() {

    val isOnlineMode: StateFlow<Boolean> = networkStateManager.isOnlineMode
    val isNetworkAvailable: StateFlow<Boolean> = networkStateManager.isNetworkAvailable

    init {
        observeNetworkStatus()
    }

    override fun doEvent(event: NetworkEvents) {
        when (event) {
            is NetworkEvents.ToggleOnlineMode -> toggleOnlineMode()
            is NetworkEvents.SetOnlineMode -> setOnlineMode(event.enabled)
        }
    }

    private fun observeNetworkStatus() {
        viewModelScope.launch {
            networkStateManager.networkMonitor.isOnline.collect { isOnline ->
                networkStateManager.updateNetworkAvailability(isOnline)
            }
        }
    }

    private fun toggleOnlineMode() {
        networkStateManager.toggleOnlineMode()
    }

    private fun setOnlineMode(enabled: Boolean) {
        networkStateManager.setOnlineMode(enabled)
    }
}

