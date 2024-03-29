package me.lincolnstuart.funblocks.components.misc.cardinfo.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.components.misc.avatar.Avatar
import me.lincolnstuart.funblocks.components.misc.avatar.utils.AvatarMode
import me.lincolnstuart.funblocks.components.misc.avatar.utils.AvatarOptions
import me.lincolnstuart.funblocks.components.misc.avatar.utils.AvatarSize
import me.lincolnstuart.funblocks.components.misc.cardinfo.CardInfo
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Sealed class that presets the [CardInfo] header customization.
 */
public sealed class CardHeaderOptions {

    @Composable
    abstract fun Content(modifier: Modifier)

    public data class Profile(val painter: Painter, val title: String? = null) : CardHeaderOptions() {
        @Composable
        override fun Content(modifier: Modifier) {
            Column(
                modifier = modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Avatar(
                    mode = AvatarMode.Image(painter = painter),
                    options = AvatarOptions(size = AvatarSize.Large)
                ) {}
                title?.let {
                    Text(
                        text = title,
                        mode = TextMode.Title(),
                        modifier = Modifier.padding(top = FunBlocksSpacing.xSmall)
                    )
                }
            }
        }
    }

    public data class Full(
        val painter: Painter,
        val title: String?,
        val height: Dp = FunBlocksContentSize.xxxHuge
    ) : CardHeaderOptions() {
        @Composable
        override fun Content(modifier: Modifier) {
            Column {
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(height)
                        .background(color = FunBlocksColors.SurfaceDark.value()),
                    contentScale = ContentScale.Crop
                )
                title?.let {
                    Text(
                        text = title,
                        mode = TextMode.Title(),
                        modifier = Modifier
                            .padding(horizontal = FunBlocksSpacing.small)
                            .padding(top = FunBlocksSpacing.small)
                    )
                }
            }
        }
    }
}
