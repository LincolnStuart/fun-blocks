package me.lincolnstuart.funblocks.components.core.bottomnavigator.utils

import androidx.compose.ui.graphics.vector.ImageVector

public data class BottomNavigationItemAction(
    val icon: ImageVector,
    val label: String? = null,
    val description: String? = null,
    val callback: () -> Unit
)
