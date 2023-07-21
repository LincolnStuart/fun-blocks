package me.lincolnstuart.funblocks.chart.pie.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize

/**
 * Sealed class that provides the type of the chart (pie/donut).
 *
 * @param isFullArea if the chart has not an empty area in the middle.
 * @param style [DrawStyle].
 */
public sealed class PieChartType(
    val isFullArea: Boolean,
    val style: @Composable () -> DrawStyle
) {
    public object Pie : PieChartType(
        isFullArea = true,
        style = { Fill }
    )

    public data class Donut(private val width: Dp = FunBlocksContentSize.xxLarge) :
        PieChartType(
            isFullArea = false,
            style = {
                val density = LocalDensity.current
                val strokeWidth = with(density) { width.toPx() }
                Stroke(width = strokeWidth, cap = StrokeCap.Butt)
            }
        )
}
