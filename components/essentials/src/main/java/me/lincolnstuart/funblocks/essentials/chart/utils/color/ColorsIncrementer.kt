package me.lincolnstuart.funblocks.essentials.chart.utils.color

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.color.alpha.FunBlocksAlpha

/**
 * Object that provides a list with a sufficient number of colors based on a number of data.
 */
internal object ColorsIncrementer {

    /**
     * Increments the colors number using a list of base colors and applying and alpha to generate
     * new colors.
     *
     * @param count number of colors need.
     * @param colors base colors.
     */
    @Composable
    fun increment(
        count: Int,
        colors: List<FunBlocksColors>
    ): List<Color> {
        val originalSize = remember(colors) {
            colors.size
        }
        val composeColors = colors.map { color -> color.value() }
        if (originalSize >= count) {
            return composeColors
        }
        val finalColorList = remember(colors) {
            buildList {
                addAll(composeColors)
                val alpha = FunBlocksAlpha.low
                var incrementalAlpha = alpha
                repeat(count - originalSize) { index ->
                    val originalIndex = index % originalSize
                    add(composeColors[originalIndex].copy(incrementalAlpha))
                    if ((originalIndex + 1) == originalSize) incrementalAlpha += alpha
                    if (incrementalAlpha > 1) incrementalAlpha = alpha
                }
            }
        }
        return finalColorList
    }
}
