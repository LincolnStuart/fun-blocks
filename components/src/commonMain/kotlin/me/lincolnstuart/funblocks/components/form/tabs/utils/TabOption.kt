package me.lincolnstuart.funblocks.components.form.tabs.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

public data class TabOption(
    val icon: ImageVector,
    val label: String? = null,
    val description: String? = null,
    val content: @Composable () -> Unit
)
