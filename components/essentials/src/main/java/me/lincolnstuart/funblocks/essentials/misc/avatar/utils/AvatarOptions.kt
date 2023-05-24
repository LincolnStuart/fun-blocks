package me.lincolnstuart.funblocks.essentials.misc.avatar.utils

/**
 * Data class that customize avatar options.
 *
 * @param shape [AvatarShape].
 * @param size [AvatarSize].
 */
public data class AvatarOptions(
    val shape: AvatarShape = AvatarShape.Circle,
    val size: AvatarSize = AvatarSize.Regular
)
