package me.lincolnstuart.funblocks.essentials.core.icon.utils

import androidx.compose.ui.unit.Dp
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize

/**
 * Enum that provides icon size based on [FunBlocksContentSize].
 *
 * @param dimension size value based on [FunBlocksContentSize].
 */
public enum class IconSize(
    val dimension: Dp
) {
    Tiny(dimension = FunBlocksContentSize.xxSmall),
    Small(dimension = FunBlocksContentSize.small),
    Medium(dimension = FunBlocksContentSize.medium),
    Large(dimension = FunBlocksContentSize.large),
    Extra(dimension = FunBlocksContentSize.huge)
}
