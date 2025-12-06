package com.example.scid_test_task.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.scid_test_task.ui.feature.favorites.FavoritesScreen
import com.example.scid_test_task.ui.feature.productdetail.ProductDetailScreen
import com.example.scid_test_task.ui.feature.productdetail.ProductDetailViewModel
import com.example.scid_test_task.ui.feature.products.ProductsScreen
import com.example.scid_test_task.ui.feature.products.ProductsViewModel

@Composable
fun NavGraph(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Products,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable<Screen.Products> { backStackEntry ->
                val viewModel: ProductsViewModel = hiltViewModel(backStackEntry)
                ProductsScreen(
                    viewModel = viewModel,
                    onProductClick = { productId ->
                        onNavigate(navController, NavigationAction.ToProductDetailsScreen(productId))
                    },
                    onFavoritesClick = {
                        onNavigate(navController, NavigationAction.ToBaseScreen(Screen.Favorites))
                    }
                )
            }
            composable<Screen.ProductDetail> { backStackEntry ->
                val productDetail: Screen.ProductDetail = backStackEntry.toRoute()
                val viewModel: ProductDetailViewModel = hiltViewModel(
                    backStackEntry
                ) { factory: ProductDetailViewModel.Factory ->
                    factory.create(productDetail.productId)
                }
                ProductDetailScreen(
                    onBackClick = { onNavigate(navController, NavigationAction.NavigateBack) },
                    viewModel = viewModel
                )
            }
            composable<Screen.Favorites> {
                FavoritesScreen(
                    onProductClick = { productId ->
                        onNavigate(navController, NavigationAction.ToProductDetailsScreen(productId))
                    }
                )
            }
        }
    }
}

