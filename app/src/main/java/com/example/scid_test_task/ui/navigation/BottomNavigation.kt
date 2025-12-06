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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.IntSize
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.toRoute
import androidx.compose.ui.platform.LocalResources

@Composable
fun BottomNavigationBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val shouldShowBottomBar =
        currentDestination?.hasRoute(Screen.Products::class) == true || currentDestination?.hasRoute(
            Screen.Favorites::class
        ) == true

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
                selected = navBackStackEntry?.destination?.hasRoute(Screen.Products::class) ?: false,
                onClick = {
                    navController.navigate(Screen.Products) {
                        popUpTo(Screen.Products) { inclusive = true }
                    }
                }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.Favorite, contentDescription = "Избранное") },
                label = { Text("Избранное") },
                selected = navBackStackEntry?.destination?.hasRoute(Screen.Favorites::class) ?: false,
                onClick = {
                    navController.navigate(Screen.Favorites)
                }
            )
        }
    }
}

