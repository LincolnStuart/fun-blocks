package me.lincolnstuart.funblocks.components.misc.divider

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import me.lincolnstuart.funblocks.components.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.components.core.surface.Surface
import me.lincolnstuart.funblocks.components.misc.divider.utils.HorizontalDividerMode
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.border.FunBlocksBorderWidth
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Horizontal divider that fills full parent width.
 *
 * @param mode [HorizontalDividerMode] line style.
 */
@Composable
public fun HorizontalDivider(
    mode: HorizontalDividerMode = HorizontalDividerMode.Solid
) {
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(FunBlocksBorderWidth.regular)
            .background(
                color = FunBlocksColors.Border.value(),
                shape = mode.shape
            )
    )
}

// @Preview
@Composable
private fun HorizontalDividerPreview() {
    FunBlocksTheme {
        Surface {
            Column(
                Modifier
                    .padding(FunBlocksSpacing.small)
                    .width(FunBlocksContentSize.xxxLarge)
            ) {
                HorizontalDivider()
                VerticalSpacer(FunBlocksSpacing.small)
                HorizontalDivider(mode = HorizontalDividerMode.Dashed)
                VerticalSpacer(FunBlocksSpacing.small)
                HorizontalDivider(mode = HorizontalDividerMode.Dotted)
            }
        }
    }
}
