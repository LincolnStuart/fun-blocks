package me.lincolnstuart.funblocks.components.misc.banner

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import me.lincolnstuart.funblocks.components.core.surface.Card
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize

/**
 * Async image banner component. Based on [Card] and [KamelImage].
 *
 * @param url image url.
 * @param height it recommended to use [FunBlocksContentSize].
 * @param modifier [Modifier].
 * @param onClick callback that executes when click is performed.
 */
@Composable
public fun Banner(
    url: String,
    modifier: Modifier = Modifier,
    height: Dp = FunBlocksContentSize.huge,
    onClick: () -> Unit
) {
    Card(modifier = modifier.clickable { onClick() }) {
        KamelImage(
            resource = asyncPainterResource(data = url),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(height)
                .fillMaxWidth()
        )
    }
}

// @Preview
@Composable
private fun BannerPreview() {
    Banner(
        url = "some.banner.here"
    ) {}
}
