package me.lincolnstuart.funblocks.playground.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import me.lincolnstuart.funblocks.components.core.appbar.AppBar
import me.lincolnstuart.funblocks.components.core.appbar.utils.AppBarOptions
import me.lincolnstuart.funblocks.components.core.surface.Surface
import me.lincolnstuart.funblocks.components.misc.divider.HorizontalDivider
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

@Composable
internal fun Sample(
    appBarOptions: AppBarOptions? = null,
    component: @Composable () -> Unit,
    options: @Composable () -> Unit
) {
    FunBlocksTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column {
                appBarOptions?.let {
                    AppBar(options = appBarOptions)
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .background(color = FunBlocksColors.SurfaceMedium.value())
                        .padding(FunBlocksSpacing.small),
                    contentAlignment = Alignment.Center
                ) {
                    component()
                }
                HorizontalDivider()
                options()
            }
        }
    }
}
