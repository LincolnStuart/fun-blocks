package me.lincolnstuart.funblocks.chart.pie.utils

import androidx.compose.ui.graphics.Color
import java.math.BigDecimal

/**
 * Data class that represents a portion of a pie/donut.
 *
 * @param description data description.
 * @param value data value.
 * @param color data color.
 */
public data class PieChartPiece(
    val description: String,
    val value: BigDecimal,
    val color: Color
) {
    fun getArea(totalValue: BigDecimal): BigDecimal =
        BigDecimal(FULL_TURN_IN_DEGREES).multiply(value).divide(totalValue)

    private companion object {
        const val FULL_TURN_IN_DEGREES: Int = 360
    }
}
