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
                        navController.navigate(Screen.ProductDetail(productId))
                    },
                    onFavoritesClick = {
                        navController.navigate(Screen.Favorites)
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
                    onBackClick = { navController.popBackStack() },
                    viewModel = viewModel
                )
            }
            composable<Screen.Favorites> {
                FavoritesScreen(
                    onProductClick = { productId ->
                        navController.navigate(Screen.ProductDetail(productId))
                    }
                )
            }
        }
    }
}

