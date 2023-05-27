package me.lincolnstuart.funblocks.essentials.misc.avatar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarOptions
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarShape
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarSize
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Avatar with an customized image from url. Based on [BasicAvatar] and [AsyncImage] from coil.
 *
 * @param url image address. E.g "https://avatars.githubusercontent.com/u/8579195?v=4".
 * @param modifier optional [Modifier].
 * @param options [AvatarOptions].
 */
@Composable
public fun ImageAvatar(
    url: String,
    modifier: Modifier = Modifier,
    options: AvatarOptions = AvatarOptions()
) {
    BasicAvatar(
        options = options,
        modifier = modifier
    ) {
        AsyncImage(
            model = url,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
private fun ImageAvatarPreview() {
    FunBlocksTheme {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ImageAvatar(
                    url = "https://avatars.githubusercontent.com/u/8579195?v=4",
                    modifier = Modifier.padding(all = FunBlocksSpacing.xxxSmall),
                    options = AvatarOptions(
                        shape = AvatarShape.Circle,
                        size = AvatarSize.Regular
                    )
                )
                ImageAvatar(
                    url = "https://avatars.githubusercontent.com/u/8579195?v=4",
                    modifier = Modifier.padding(all = FunBlocksSpacing.xxxSmall),
                    options = AvatarOptions(
                        shape = AvatarShape.Circle,
                        size = AvatarSize.Large
                    )
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ImageAvatar(
                    url = "https://avatars.githubusercontent.com/u/8579195?v=4",
                    modifier = Modifier.padding(all = FunBlocksSpacing.xxxSmall),
                    options = AvatarOptions(
                        shape = AvatarShape.Square,
                        size = AvatarSize.Regular
                    )
                )
                ImageAvatar(
                    url = "https://avatars.githubusercontent.com/u/8579195?v=4",
                    modifier = Modifier.padding(all = FunBlocksSpacing.xxxSmall),
                    options = AvatarOptions(
                        shape = AvatarShape.Square,
                        size = AvatarSize.Large
                    )
                )
            }
        }
    }
}
