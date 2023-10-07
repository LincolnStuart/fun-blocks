package me.lincolnstuart.funblocks.components.misc.banner

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import me.lincolnstuart.funblocks.components.core.surface.Card
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize

/**
 * Async image banner component. Based on [Card] and [Image].
 *
 * @param painter image resource.
 * @param height it recommended to use [FunBlocksContentSize].
 * @param modifier [Modifier].
 * @param onClick callback that executes when click is performed.
 */
@Composable
public fun Banner(
    painter: Painter,
    modifier: Modifier = Modifier,
    height: Dp = FunBlocksContentSize.huge,
    onClick: () -> Unit
) {
    Card(modifier = modifier.clickable { onClick() }) {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(height)
                .fillMaxWidth()
        )
    }
}
