package me.lincolnstuart.funblocks.components.core.appbar.utils

import androidx.compose.runtime.Composable

data class AppBarOptions(
    val mainContent: @Composable () -> Unit,
    val mainAction: AppBarAction? = null,
    val secondaryOptions: (@Composable () -> Unit)? = null
)
