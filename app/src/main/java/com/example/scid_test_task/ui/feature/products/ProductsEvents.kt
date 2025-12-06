package com.example.scid_test_task.ui.feature.products

import com.example.scid_test_task.core.mvi.Events

sealed class ProductsEvents : Events {
    object Init : ProductsEvents()
    object LoadCategories : ProductsEvents()
    data class SelectCategory(val category: String?) : ProductsEvents()
    data class UpdateSearchQuery(val query: String) : ProductsEvents()
    object LoadProducts : ProductsEvents()
    object RefreshProducts : ProductsEvents()
}

