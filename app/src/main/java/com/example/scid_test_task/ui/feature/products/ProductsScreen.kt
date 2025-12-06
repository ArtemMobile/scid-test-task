package com.example.scid_test_task.ui.feature.products

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.scid_test_task.domain.util.Result
import com.example.scid_test_task.core.network.NetworkEvents
import com.example.scid_test_task.core.network.NetworkViewModel
import com.example.scid_test_task.ui.feature.products.components.CategoriesRow
import com.example.scid_test_task.ui.feature.products.components.ProductsContent
import com.example.scid_test_task.ui.feature.products.components.ProductsSearchBar
import com.example.scid_test_task.ui.feature.products.components.ProductsTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsScreen(
    onProductClick: (Int) -> Unit,
    onFavoritesClick: () -> Unit,
    viewModel: ProductsViewModel,
    networkViewModel: NetworkViewModel = hiltViewModel()
) {
    val selectedCategory by viewModel.selectedCategory.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val categories by viewModel.categories.collectAsState()
    val productsState by viewModel.productsState.collectAsState()
    val isOnlineMode by networkViewModel.isOnlineMode.collectAsState()
    val isNetworkAvailable by networkViewModel.isNetworkAvailable.collectAsState()

    Scaffold(
        topBar = {
            ProductsTopBar(
                isOnlineMode = isOnlineMode,
                isNetworkAvailable = isNetworkAvailable,
                onToggleNetworkMode = { networkViewModel.doEvent(NetworkEvents.ToggleOnlineMode) },
                onFavoritesClick = onFavoritesClick
            )
        }
    ) { paddingValues ->
        PullToRefreshBox(
            modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
            isRefreshing = productsState is Result.Loading,
            onRefresh = { viewModel.doEvent(ProductsEvents.RefreshProducts) }
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                ProductsSearchBar(
                    searchQuery = searchQuery,
                    onSearchQueryChange = { query ->
                        viewModel.doEvent(ProductsEvents.UpdateSearchQuery(query))
                    }
                )

                if (categories.isNotEmpty()) {
                    CategoriesRow(
                        categories = categories,
                        selectedCategory = selectedCategory,
                        onCategorySelected = { category ->
                            viewModel.doEvent(ProductsEvents.SelectCategory(category))
                        }
                    )
                }

                ProductsContent(
                    productsState = productsState,
                    searchQuery = searchQuery,
                    onProductClick = onProductClick,
                    onRetry = { viewModel.doEvent(ProductsEvents.RefreshProducts) }
                )
            }
        }
    }
}

