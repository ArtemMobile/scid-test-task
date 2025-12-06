package com.example.scid_test_task.ui.feature.products

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
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
    val productsPaged = viewModel.productsPaged
    val lazyPagingItems = productsPaged.collectAsLazyPagingItems()
    val isOnlineMode by networkViewModel.isOnlineMode.collectAsState()
    val isNetworkAvailable by networkViewModel.isNetworkAvailable.collectAsState()

    val isRefreshing = lazyPagingItems.loadState.refresh is LoadState.Loading

    Scaffold(
        topBar = {
            ProductsTopBar(
                isOnlineMode = isOnlineMode,
                isNetworkAvailable = isNetworkAvailable,
                onFavoritesClick = onFavoritesClick
            )
        }
    ) { paddingValues ->
        PullToRefreshBox(
            modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
            isRefreshing = isRefreshing,
            onRefresh = {
                viewModel.doEvent(ProductsEvents.UpdateSearchQuery(""))
                lazyPagingItems.refresh()
            }
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
                    productsPaged = productsPaged,
                    searchQuery = searchQuery,
                    onProductClick = onProductClick
                )
            }
        }
    }
}

