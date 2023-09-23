package me.lincolnstuart.funblocks.components.core.spacer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Wrapper from [Spacer] that apply only width value.
 *
 * @param width [Dp], it is recommended to use [FunBlocksSpacing].
 */
@Composable
fun HorizontalSpacer(
    width: Dp
) {
    Spacer(modifier = Modifier.width(width))
}
