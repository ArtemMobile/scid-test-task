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
        val products = lazyPagingItems.itemSnapshotList.items
            .distinctBy { it.id }
            .filter { product ->
                searchQuery.isBlank() || product.title.contains(searchQuery, ignoreCase = true)
            }
        products
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
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

        if (displayedProducts.isEmpty() && lazyPagingItems.loadState.refresh !is LoadState.Loading) {
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
    }
}

