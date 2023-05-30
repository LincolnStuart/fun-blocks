package me.lincolnstuart.funblocks.essentials.misc.avatar.utils

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import me.lincolnstuart.funblocks.core.icon.utils.IconSize
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import me.lincolnstuart.funblocks.foundation.ui.token.font.FunBlocksFontSize

/**
 * Enum that provides all sizes that the avatar may use.
 *
 * @param size component size.
 * @param iconSize from [AvatarMode.Icon].
 * @param fontSize from [AvatarMode.Initials].
 */
public enum class AvatarSize(
    val size: Dp,
    val iconSize: IconSize,
    val fontSize: TextUnit
) {
    Small(
        size = FunBlocksContentSize.medium,
        iconSize = IconSize.Tiny,
        fontSize = FunBlocksFontSize.medium
    ),
    Regular(
        size = FunBlocksContentSize.xLarge,
        iconSize = IconSize.Medium,
        fontSize = FunBlocksFontSize.xLarge
    ),
    Large(
        size = FunBlocksContentSize.huge,
        iconSize = IconSize.Large,
        fontSize = FunBlocksFontSize.huge
    )
}
