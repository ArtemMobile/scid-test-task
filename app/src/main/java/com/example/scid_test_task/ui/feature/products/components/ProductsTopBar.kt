package com.example.scid_test_task.ui.feature.products.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsTopBar(
    isOnlineMode: Boolean,
    isNetworkAvailable: Boolean,
    onToggleNetworkMode: () -> Unit,
    onFavoritesClick: () -> Unit
) {
    TopAppBar(
        title = { Text("Каталог товаров") },
        actions = {
            NetworkModeSwitch(
                isOnlineMode = isOnlineMode,
                isNetworkAvailable = isNetworkAvailable,
                onToggle = onToggleNetworkMode
            )
            IconButton(onClick = onFavoritesClick) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Избранное"
                )
            }
        }
    )
}

