package me.lincolnstuart.funblocks.essentials.misc.avatar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import compose.icons.TablerIcons
import compose.icons.tablericons.User
import me.lincolnstuart.funblocks.core.icon.Icon
import me.lincolnstuart.funblocks.core.icon.utils.IconOptions
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarOptions
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarShape
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarSize
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Avatar with an customized icon. Based on [BasicAvatar].
 *
 * @param modifier optional [Modifier].
 * @param icon [ImageVector].
 * @param options [AvatarOptions].
 * @param color [FunBlocksColors] for avatar icon.
 */
@Composable
public fun IconAvatar(
    modifier: Modifier = Modifier,
    icon: ImageVector = TablerIcons.User,
    options: AvatarOptions = AvatarOptions(),
    color: FunBlocksColors = FunBlocksColors.NeutralDark
) {
    BasicAvatar(
        options = options,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                options = IconOptions(
                    description = null,
                    size = options.size.iconSize,
                    color = color
                )
            )
        }
    }
}

@Preview
@Composable
private fun IconAvatarPreview() {
    FunBlocksTheme {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconAvatar(
                    options = AvatarOptions(
                        shape = AvatarShape.Circle,
                        size = AvatarSize.Regular
                    ),
                    modifier = Modifier.padding(all = FunBlocksSpacing.xxxSmall)
                )
                IconAvatar(
                    options = AvatarOptions(
                        shape = AvatarShape.Circle,
                        size = AvatarSize.Large
                    ),
                    modifier = Modifier.padding(all = FunBlocksSpacing.xxxSmall)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconAvatar(
                    options = AvatarOptions(
                        shape = AvatarShape.Square,
                        size = AvatarSize.Regular
                    ),
                    modifier = Modifier.padding(all = FunBlocksSpacing.xxxSmall)
                )
                IconAvatar(
                    options = AvatarOptions(
                        shape = AvatarShape.Square,
                        size = AvatarSize.Large
                    ),
                    modifier = Modifier.padding(all = FunBlocksSpacing.xxxSmall)
                )
            }
        }
    }
}
