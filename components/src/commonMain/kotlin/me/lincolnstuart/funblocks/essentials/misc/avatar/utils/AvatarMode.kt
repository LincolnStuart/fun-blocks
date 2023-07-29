package me.lincolnstuart.funblocks.essentials.misc.avatar.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import compose.icons.TablerIcons
import compose.icons.tablericons.User
import me.lincolnstuart.funblocks.essentials.core.icon.Icon
import me.lincolnstuart.funblocks.essentials.core.icon.utils.IconOptions
import me.lincolnstuart.funblocks.essentials.core.text.Text
import me.lincolnstuart.funblocks.essentials.core.text.utils.TextMode
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing
import me.lincolnstuart.funblocks.foundation.ui.token.font.FunBlocksFontWeight

public sealed class AvatarMode {

    @Composable
    internal abstract fun Content(options: AvatarOptions)

    /**
     * Avatar with an customized icon.
     *
     * @param icon [ImageVector].
     */
    public data class Icon(
        val icon: ImageVector = TablerIcons.User
    ) : AvatarMode() {

        @Composable
        override fun Content(options: AvatarOptions) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    options = IconOptions(
                        description = null,
                        size = options.size.iconSize,
                        color = options.contentColor
                    )
                )
            }
        }
    }

    /**
     * Avatar with an customized image from url, based on [AsyncImage] from coil.
     *
     * @param url image address. E.g "https://avatars.githubusercontent.com/u/8579195?v=4".
     */
    public data class Image(
        val url: String
    ) : AvatarMode() {

        @Composable
        override fun Content(options: AvatarOptions) {
            AsyncImage(
                model = url,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }

    /**
     * Avatar with name initials, based on [InitialsHelper]. The initials are from first and last name.
     * E.g "Lincoln Middle Name Stuart" -> LS.
     *
     * @param fullName an user full name.
     */
    public data class Initials(
        val fullName: String
    ) : AvatarMode() {

        @Composable
        override fun Content(options: AvatarOptions) {
            val initials = remember {
                InitialsHelper.getInitials(fullName)
            }
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = initials,
                    modifier = Modifier.padding(all = FunBlocksSpacing.xxxSmall),
                    mode = TextMode.Custom(
                        fontSize = options.size.fontSize,
                        fontWeight = FunBlocksFontWeight.semiBold
                    ),
                    color = options.contentColor
                )
            }
        }
    }
}
