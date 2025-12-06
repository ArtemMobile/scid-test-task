package com.example.scid_test_task.ui.feature.products.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NetworkModeSwitch(
    isOnlineMode: Boolean,
    isNetworkAvailable: Boolean,
    onToggle: () -> Unit
) {
    Row(
        modifier = Modifier.padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            imageVector = if (isNetworkAvailable) Icons.Filled.Check else Icons.Default.Clear,
            contentDescription = if (isNetworkAvailable) "Сеть доступна" else "Сеть недоступна",
            tint = if (isNetworkAvailable) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
        )
        Switch(
            checked = isOnlineMode,
            onCheckedChange = { onToggle() },
            enabled = isNetworkAvailable
        )
        Text(
            text = if (isOnlineMode) "Online" else "Offline",
            style = MaterialTheme.typography.labelSmall,
            color = if (isOnlineMode) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
        )
    }
}

