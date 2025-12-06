package com.example.scid_test_task.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data object Products : Screen()

    @Serializable
    data class ProductDetail(val productId: Int) : Screen()

    @Serializable
    data object Favorites : Screen()
}

val fullScreenPages = listOf(Screen.ProductDetail::class)