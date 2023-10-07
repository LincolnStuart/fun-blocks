package me.lincolnstuart.funblocks.playground.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

@Composable
internal fun ComponentWithOptions(
    mainContent: @Composable () -> Unit,
    options: @Composable () -> Unit
) {
    Column {
        ComponentCentralizer(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .padding(FunBlocksSpacing.small)
        ) {
            mainContent()
        }
        options()
    }
}
