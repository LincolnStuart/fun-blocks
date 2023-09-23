package me.lincolnstuart.funblocks.components.misc.divider.utils

import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Enum that provides horizontal divider style.
 *
 * @param shape to dash or dot style, it is recommended to use [HorizontalDashShape]
 */
public enum class HorizontalDividerMode(val shape: Shape) {
    Solid(shape = RectangleShape),
    Dashed(
        shape = HorizontalDashShape(
            lineWidth = FunBlocksSpacing.small
        )
    ),
    Dotted(
        shape = HorizontalDashShape(
            lineWidth = FunBlocksSpacing.xxSmall
        )
    )
}
