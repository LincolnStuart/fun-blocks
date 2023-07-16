package me.lincolnstuart.funblocks.foundation.ui.token.content.spacing

import androidx.compose.foundation.layout.PaddingValues

/**
 * Object that provides inset spacing tokens to standard surface components.
 *
 * Based on [androidx.compose.foundation.layout.PaddingValues].
 */
public object FunBlocksInset {
    public val small: PaddingValues = PaddingValues(
        vertical = FunBlocksSpacing.xxxSmall,
        horizontal = FunBlocksSpacing.xxSmall
    )
    public val medium: PaddingValues = PaddingValues(
        vertical = FunBlocksSpacing.xxSmall,
        horizontal = FunBlocksSpacing.small
    )
    public val large: PaddingValues = PaddingValues(
        vertical = FunBlocksSpacing.small,
        horizontal = FunBlocksSpacing.large
    )
    public val extra: PaddingValues = PaddingValues(
        vertical = FunBlocksSpacing.small,
        horizontal = FunBlocksSpacing.xLarge
    )
}
