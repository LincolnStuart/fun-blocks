package me.lincolnstuart.funblocks.components.core.icon.utils

import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors

/**
 * Data class that customize icon options.
 *
 * @param description to accessibility.
 * @param size [IconSize].
 * @param color icon color.
 */
public data class IconOptions(
    val description: String?,
    val size: IconSize,
    val color: FunBlocksColors = FunBlocksColors.NeutralDark
)
