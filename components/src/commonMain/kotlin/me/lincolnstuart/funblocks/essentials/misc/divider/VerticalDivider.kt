package me.lincolnstuart.funblocks.essentials.misc.divider

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.lincolnstuart.funblocks.essentials.core.spacer.HorizontalSpacer
import me.lincolnstuart.funblocks.essentials.core.surface.Surface
import me.lincolnstuart.funblocks.essentials.misc.divider.utils.VerticalDividerMode
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.border.FunBlocksBorderWidth
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Vertical divider that fills full parent height.
 *
 * @param mode [VerticalDividerMode] line style.
 */
@Composable
public fun VerticalDivider(
    mode: VerticalDividerMode = VerticalDividerMode.Solid
) {
    Spacer(
        modifier = Modifier
            .fillMaxHeight()
            .width(FunBlocksBorderWidth.regular)
            .background(
                color = FunBlocksColors.Border.value(),
                shape = mode.shape
            )
    )
}

@Preview
@Composable
private fun VerticalDividerPreview() {
    FunBlocksTheme {
        Surface {
            Row(
                Modifier
                    .padding(FunBlocksSpacing.small)
                    .height(FunBlocksContentSize.xxxLarge)
            ) {
                VerticalDivider()
                HorizontalSpacer(FunBlocksSpacing.small)
                VerticalDivider(mode = VerticalDividerMode.Dashed)
                HorizontalSpacer(FunBlocksSpacing.small)
                VerticalDivider(mode = VerticalDividerMode.Dotted)
            }
        }
    }
}
