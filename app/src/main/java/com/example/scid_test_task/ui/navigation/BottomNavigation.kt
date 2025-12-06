package com.example.scid_test_task.ui.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.IntSize
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.ui.platform.LocalResources
import androidx.navigation.NavHostController
import com.example.scid_test_task.ui.navigation.Screen.*

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val shouldShowBottomBar = fullScreenPages.none {
        currentDestination?.hasRoute(it) == true
    }

    val widthScreen = LocalResources.current.displayMetrics.widthPixels

    val transactionAnimEnter = expandIn(
        expandFrom = Alignment.BottomCenter,
        initialSize = { IntSize(widthScreen, 0) }
    ) + fadeIn()

    val transactionAnimExit = shrinkOut(
        animationSpec = spring(
            stiffness = Spring.StiffnessMedium,
            visibilityThreshold = IntSize.VisibilityThreshold
        ),
        shrinkTowards = Alignment.BottomCenter,
        targetSize = { IntSize(widthScreen, 0) }) + fadeOut()

    AnimatedVisibility(
        visible = shouldShowBottomBar,
        enter = transactionAnimEnter,
        exit = transactionAnimExit
    ) {
        NavigationBar {
            NavigationBarItem(
                icon = { Icon(Icons.Default.Home, contentDescription = "Товары") },
                label = { Text("Товары") },
                selected = navBackStackEntry?.destination?.hasRoute(Products::class)
                    ?: false,
                onClick = {
                    onBottomItemClick(navController, Products)
                }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.Favorite, contentDescription = "Избранное") },
                label = { Text("Избранное") },
                selected = navBackStackEntry?.destination?.hasRoute(Favorites::class)
                    ?: false,
                onClick = {
                    onBottomItemClick(navController, Favorites)
                }
            )
        }
    }
}

private fun onBottomItemClick(
    navController: NavHostController,
    screen: Screen,
) {
    val isMenuItemSelected =
        navController.currentBackStackEntry?.destination?.hasRoute(screen::class) == true

    val navigationAction = if (isMenuItemSelected) {
        NavigationAction.ToSameBaseScreen(screen)
    } else {
        NavigationAction.ToBaseScreen(screen)
    }
    onNavigate(navController, navigationAction)
}

fun onNavigate(navController: NavController, action: NavigationAction) {
    when (action) {
        is NavigationAction.ToBaseScreen -> {
            navController.navigate(action.route) {
                launchSingleTop = true
                restoreState = true
                popUpTo(navController.graph.startDestinationId) {
                    saveState = true
                }
            }
        }

        is NavigationAction.ToSameBaseScreen -> {
            navController.navigate(action.route) {
                launchSingleTop = true
                restoreState = true
                popUpTo(navController.graph.startDestinationId) {
                    saveState = true
                }
            }
        }

        is NavigationAction.ToProductDetailsScreen -> {
            navController.navigate(ProductDetail(action.productId))
        }

        NavigationAction.NavigateBack -> {
            if (navController.previousBackStackEntry != null) {
                navController.popBackStack()
            }
        }
    }
}

sealed class NavigationAction {
    data class ToBaseScreen(val route: Screen) : NavigationAction()
    data class ToSameBaseScreen(val route: Screen) : NavigationAction()
    data class ToProductDetailsScreen(val productId: Int) : NavigationAction()
    data object NavigateBack : NavigationAction()
}

