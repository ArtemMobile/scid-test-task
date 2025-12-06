package com.example.scid_test_task.ui.feature.productdetail

import com.example.scid_test_task.core.mvi.Events

sealed class ProductDetailEvents : Events {
    object Refresh : ProductDetailEvents()
    object ToggleFavorite : ProductDetailEvents()
}

