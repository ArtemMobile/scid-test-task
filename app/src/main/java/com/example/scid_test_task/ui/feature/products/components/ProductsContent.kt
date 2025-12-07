package com.example.scid_test_task.ui.feature.products.components

import androidx.compose.runtime.*
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.scid_test_task.domain.model.Product
import kotlinx.coroutines.flow.Flow
import androidx.paging.PagingData

@Composable
fun ProductsContent(
    productsPaged: Flow<PagingData<Product>>,
    searchQuery: String,
    onProductClick: (Int) -> Unit,
    onRefresh: () -> Unit
) {
    val lazyPagingItems: LazyPagingItems<Product> = productsPaged.collectAsLazyPagingItems()

    ProductsList(
        lazyPagingItems = lazyPagingItems,
        searchQuery = searchQuery,
        onProductClick = onProductClick,
        onRefresh = onRefresh
    )
}
