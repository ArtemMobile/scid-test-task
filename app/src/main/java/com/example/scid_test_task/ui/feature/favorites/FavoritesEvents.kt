package com.example.scid_test_task.ui.feature.favorites

import com.example.scid_test_task.core.mvi.Events

sealed class FavoritesEvents : Events {
    data class RemoveFavorite(val productId: Int) : FavoritesEvents()
}

