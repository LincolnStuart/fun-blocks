package me.lincolnstuart.funblocks.essentials.misc.divider.utils

import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Enum that provides vertical divider style.
 *
 * @param shape to dash or dot style, it is recommended to use [VerticalDashShape]
 */
public enum class VerticalDividerMode(val shape: Shape) {
    Solid(shape = RectangleShape),
    Dashed(
        shape = VerticalDashShape(
            lineHeight = FunBlocksSpacing.small
        )
    ),
    Dotted(
        shape = VerticalDashShape(
            lineHeight = FunBlocksSpacing.xxxSmall,
            isMoreSpaced = true
        )
    )
}
