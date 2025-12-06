package com.example.scid_test_task.ui.feature.products.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.scid_test_task.domain.model.Product

@Composable
fun ProductsList(
    lazyPagingItems: LazyPagingItems<Product>,
    searchQuery: String,
    onProductClick: (Int) -> Unit
) {
    when (val refreshState = lazyPagingItems.loadState.refresh) {
        is LoadState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
            return
        }
        is LoadState.Error -> {
            ErrorView(
                message = refreshState.error.message ?: "Ошибка загрузки данных",
                onRetry = { lazyPagingItems.retry() }
            )
            return
        }
        else -> {
        }
    }

    val displayedProducts = remember(lazyPagingItems.itemSnapshotList.items, searchQuery) {
        if (searchQuery.isNotBlank()) {
            lazyPagingItems.itemSnapshotList.items
                .filterNotNull()
                .distinctBy { it.id }
                .filter { product ->
                    product.title.contains(searchQuery, ignoreCase = true)
                }
        } else {
            null
        }
    }

    val hasMatchingProducts = remember(lazyPagingItems.itemSnapshotList.items, searchQuery) {
        lazyPagingItems.itemSnapshotList.items.any { product ->
            product != null && (searchQuery.isBlank() || product.title.contains(searchQuery, ignoreCase = true))
        }
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        if (displayedProducts != null) {
            items(
                count = displayedProducts.size,
                key = { index -> displayedProducts[index].id }
            ) { index ->
                val product = displayedProducts[index]
                ProductItem(
                    product = product,
                    onClick = { onProductClick(product.id) }
                )
            }
        } else {
            items(
                count = lazyPagingItems.itemCount,
                key = { index ->
                    "item_$index"
                }
            ) { index ->
                val product = lazyPagingItems[index]
                
                if (product != null) {
                    ProductItem(
                        product = product,
                        onClick = { onProductClick(product.id) }
                    )
                } else {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
        }

        when (val appendState = lazyPagingItems.loadState.append) {
            is LoadState.Loading -> {
                if (searchQuery.isBlank()) {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }
            }
            is LoadState.Error -> {
                item {
                    ErrorView(
                        message = appendState.error.message ?: "Ошибка загрузки данных",
                        onRetry = { lazyPagingItems.retry() }
                    )
                }
            }
            else -> {}
        }

        if (!hasMatchingProducts && lazyPagingItems.itemSnapshotList.items.any { it != null } && 
            lazyPagingItems.loadState.refresh !is LoadState.Loading) {
            item {
                EmptyView(
                    message = if (searchQuery.isNotBlank()) {
                        "По запросу \"$searchQuery\" ничего не найдено"
                    } else {
                        "Товары не найдены"
                    }
                )
            }
        }
        
        if (lazyPagingItems.itemCount == 0 && lazyPagingItems.loadState.refresh !is LoadState.Loading) {
            item {
                EmptyView(
                    message = "Товары не найдены"
                )
            }
        }
    }
}

