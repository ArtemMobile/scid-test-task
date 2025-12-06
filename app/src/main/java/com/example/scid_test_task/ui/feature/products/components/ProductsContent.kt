package com.example.scid_test_task.ui.feature.products.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.scid_test_task.domain.model.Product
import com.example.scid_test_task.domain.util.Result

@Composable
fun ProductsContent(
    productsState: Result<List<Product>>,
    searchQuery: String,
    onProductClick: (Int) -> Unit,
    onRetry: () -> Unit
) {
    when (productsState) {
        is Result.Loading -> {
            LoadingView()
        }

        is Result.Error -> {
            ErrorView(
                message = productsState.errorMessage,
                onRetry = onRetry
            )
        }

        is Result.Success -> {
            ProductsSuccessContent(
                products = productsState.data,
                searchQuery = searchQuery,
                onProductClick = onProductClick
            )
        }
    }
}

@Composable
private fun ProductsSuccessContent(
    products: List<Product>,
    searchQuery: String,
    onProductClick: (Int) -> Unit
) {
    val filteredProducts = remember(products, searchQuery) {
        if (searchQuery.isBlank()) {
            products
        } else {
            products.filter {
                it.title.contains(searchQuery, ignoreCase = true)
            }
        }
    }

    if (filteredProducts.isEmpty()) {
        EmptyView(
            message = if (searchQuery.isNotBlank()) {
                "По запросу \"$searchQuery\" ничего не найдено"
            } else {
                "Товары не найдены"
            }
        )
    } else {
        ProductsList(
            products = filteredProducts,
            onProductClick = onProductClick
        )
    }
}

@Composable
private fun LoadingView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

