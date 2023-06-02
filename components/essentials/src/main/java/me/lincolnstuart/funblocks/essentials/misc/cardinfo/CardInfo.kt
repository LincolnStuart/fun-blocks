package me.lincolnstuart.funblocks.essentials.misc.cardinfo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import me.lincolnstuart.funblocks.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.core.surface.Surface
import me.lincolnstuart.funblocks.essentials.misc.cardinfo.utils.CardBodyOptions
import me.lincolnstuart.funblocks.essentials.misc.cardinfo.utils.CardHeaderOptions
import me.lincolnstuart.funblocks.essentials.surface.card.Card
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Generic card with info about a subject.
 *
 * @param body [CardBodyOptions] to customize the card body.
 * @param modifier [Modifier]
 * @param header [CardHeaderOptions] to customize the card header.
 */
@Composable
public fun CardInfo(
    body: CardBodyOptions,
    modifier: Modifier = Modifier,
    header: CardHeaderOptions? = null
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column {
            header?.let {
                header.Content(
                    Modifier.padding(top = FunBlocksSpacing.small)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(FunBlocksSpacing.small)
            ) {
                body.Content()
            }
        }
    }
}

@Preview
@Composable
private fun ImageCardInfoPreview() {
    FunBlocksTheme {
        Surface {
            Column(Modifier.padding(FunBlocksSpacing.small)) {
                CardInfo(
                    header = CardHeaderOptions.Profile(url = "https://avatars.githubusercontent.com/u/8579195?v=4"),
                    body = CardBodyOptions.Legend(LoremIpsum(words = 50).values.first())
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                CardInfo(
                    header = CardHeaderOptions.Full(
                        url = "https://avatars.githubusercontent.com/u/8579195?v=4",
                        title = "Test",
                        height = FunBlocksContentSize.huge
                    ),
                    body = CardBodyOptions.Legend(LoremIpsum(words = 50).values.first())
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                CardInfo(body = CardBodyOptions.Legend(LoremIpsum(words = 50).values.first()))
                VerticalSpacer(height = FunBlocksSpacing.small)
                CardInfo(body = CardBodyOptions.Listing(listOf("Lincoln", "Stuart")))
                VerticalSpacer(height = FunBlocksSpacing.small)
                CardInfo(
                    body = CardBodyOptions.Characteristic(
                        mapOf(
                            Pair(
                                "First name",
                                "Lincoln"
                            ),
                            Pair("Last name", "Stuart")
                        )
                    )
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
            }
        }
    }
}
