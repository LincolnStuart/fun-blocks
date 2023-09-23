package me.lincolnstuart.funblocks.components.chart.pie.utils

import androidx.compose.ui.graphics.Color

/**
 * Data class that represents a portion of a pie/donut.
 *
 * @param description data description.
 * @param value data value.
 * @param color data color.
 */
public data class PieChartPiece(
    val description: String,
    val value: Double,
    val color: Color
) {
    fun getArea(totalValue: Double): Double =
        FULL_TURN_IN_DEGREES.toDouble() * value / totalValue

    private companion object {
        const val FULL_TURN_IN_DEGREES: Int = 360
    }
}
