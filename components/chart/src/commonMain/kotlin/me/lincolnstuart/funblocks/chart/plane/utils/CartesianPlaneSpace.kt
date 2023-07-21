package me.lincolnstuart.funblocks.chart.plane.utils

import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Data class that represents the cartesian plane usable area.
 *
 * @param height it recommends to use [FunBlocksSpacing] and convert to PX.
 * @param width it recommends to use [FunBlocksSpacing] and convert to PX.
 */
internal data class CartesianPlaneSpace(
    val height: Float,
    val width: Float
)
