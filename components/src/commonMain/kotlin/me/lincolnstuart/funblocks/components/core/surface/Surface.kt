package me.lincolnstuart.funblocks.components.core.surface

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors

/**
 * Basic surface component that provides a background to put components inside.
 *
 * @param modifier optional [Modifier].
 * @param content the content inside.
 */
@Composable
fun Surface(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier.background(FunBlocksColors.Surface.value())
    ) {
        content()
    }
}
