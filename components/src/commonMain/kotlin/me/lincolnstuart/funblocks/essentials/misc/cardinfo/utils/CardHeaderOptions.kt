package me.lincolnstuart.funblocks.essentials.misc.cardinfo.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import coil.compose.AsyncImage
import me.lincolnstuart.funblocks.essentials.core.text.Text
import me.lincolnstuart.funblocks.essentials.core.text.utils.TextMode
import me.lincolnstuart.funblocks.essentials.misc.avatar.Avatar
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarMode
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarOptions
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarSize
import me.lincolnstuart.funblocks.essentials.misc.cardinfo.CardInfo
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Sealed class that presets the [CardInfo] header customization.
 */
public sealed class CardHeaderOptions {

    @Composable
    abstract fun Content(modifier: Modifier)

    public data class Profile(val url: String, val title: String? = null) : CardHeaderOptions() {
        @Composable
        override fun Content(modifier: Modifier) {
            Column(
                modifier = modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Avatar(
                    mode = AvatarMode.Image(url = url),
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
        val url: String,
        val title: String?,
        val height: Dp = FunBlocksContentSize.xxxHuge
    ) : CardHeaderOptions() {
        @Composable
        override fun Content(modifier: Modifier) {
            Column {
                AsyncImage(
                    model = url,
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
