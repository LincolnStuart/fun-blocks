package me.lincolnstuart.funblocks.components.core.appbar.utils

import androidx.compose.ui.graphics.vector.ImageVector

public data class AppBarAction(
    val icon: ImageVector,
    val description: String? = null,
    val callback: () -> Unit
)
