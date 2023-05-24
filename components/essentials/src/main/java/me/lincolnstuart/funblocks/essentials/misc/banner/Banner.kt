package me.lincolnstuart.funblocks.essentials.misc.banner

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import me.lincolnstuart.funblocks.essentials.surface.card.Card

/**
 * Async image banner component. Based on [Card] and [AsyncImage].
 *
 * @param url image url.
 * @param modifier [Modifier].
 */
@Composable
public fun Banner(
    url: String,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        AsyncImage(
            model = url,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun BannerPreview() {
    Banner(
        url = "some.banner.here"
    )
}
