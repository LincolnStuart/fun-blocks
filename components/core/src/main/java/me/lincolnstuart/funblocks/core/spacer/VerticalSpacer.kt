package me.lincolnstuart.funblocks.core.spacer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Wrapper from [Spacer] that apply only height value.
 *
 * @param height [Dp], it is recommended to use [FunBlocksSpacing].
 */
@Composable
fun VerticalSpacer(
    height: Dp
) {
    Spacer(modifier = Modifier.height(height))
}
