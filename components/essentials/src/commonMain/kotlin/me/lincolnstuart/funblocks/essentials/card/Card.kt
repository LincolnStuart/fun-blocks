package me.lincolnstuart.funblocks.essentials.card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import me.lincolnstuart.funblocks.core.surface.Surface
import me.lincolnstuart.funblocks.core.text.Text
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.content.elevation.FunBlocksElevationLevel
import me.lincolnstuart.funblocks.foundation.ui.token.content.shape.FunBlocksCornerRadius
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksInset

/**
 * Basic component of card with elevation.
 *
 * @param modifier [Modifier].
 * @param content the content inside.
 */
@Composable
public fun Card(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Surface(
        modifier
            .shadow(elevation = FunBlocksElevationLevel.high)
            .clip(shape = FunBlocksCornerRadius.medium)
    ) {
        content()
    }
}

@Preview
@Composable
private fun CardPreview() {
    FunBlocksTheme {
        Surface {
            Card {
                Box(
                    modifier = Modifier
                        .padding(FunBlocksInset.medium)
                        .fillMaxWidth()
                ) {
                    Text(text = "Card example")
                }
            }
        }
    }
}
