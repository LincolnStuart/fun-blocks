package me.lincolnstuart.funblocks.components.misc.avatar.utils

import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors

/**
 * Data class that customize avatar options.
 *
 * @param shape [AvatarShape].
 * @param size [AvatarSize].
 * @param contentColor [FunBlocksColors] used in icons and texts.
 */
public data class AvatarOptions(
    val shape: AvatarShape = AvatarShape.Circle,
    val size: AvatarSize = AvatarSize.Regular,
    val contentColor: FunBlocksColors = FunBlocksColors.PrimaryContrast
)
