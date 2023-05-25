package me.lincolnstuart.funblocks.essentials.misc.divider.utils

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import me.lincolnstuart.funblocks.foundation.ui.token.content.border.FunBlocksBorderWidth
import kotlin.math.roundToInt

/**
 * Horizontal dashed shape, used to customize horizontal divider.
 *
 * @param lineWidth it is recommended to use [FunBlocksBorderWidth]
 * @param isMoreSpaced if empty space is greater than filled space.
 */
internal class HorizontalDashShape(
    private val lineWidth: Dp,
    private val isMoreSpaced: Boolean = false
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ) = Outline.Generic(
        Path().apply {
            val stepPx = with(density) { lineWidth.toPx() }
            val stepsCount = (size.width / stepPx).roundToInt()
            val actualStep = size.width / stepsCount
            val dotSize = Size(width = actualStep / 2, height = size.height)
            for (i in 0 until stepsCount) {
                addRect(
                    Rect(
                        offset = getOffset(index = i, actualStep = actualStep),
                        size = dotSize
                    )
                )
            }
            close()
        }
    )

    private fun getOffset(index: Int, actualStep: Float): Offset {
        var offsetValue = index * actualStep
        if (isMoreSpaced) offsetValue *= EXTRA_SPACE
        return Offset(x = offsetValue, y = 0f)
    }

    private companion object {
        const val EXTRA_SPACE: Float = 2.5f
    }
}
