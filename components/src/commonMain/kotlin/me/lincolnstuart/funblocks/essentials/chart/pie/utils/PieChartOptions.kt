package me.lincolnstuart.funblocks.essentials.chart.pie.utils

import androidx.compose.ui.unit.Dp
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize

/**
 * Data class to customize the pie chart.
 *
 * @param title chart description.
 * @param isAnimated if starts with animation.
 * @param size it is recommended to use [FunBlocksContentSize].
 * @param type [PieChartType] pie/donut.
 * @param legendColumns of columns per line on the legend.
 */
public data class PieChartOptions(
    val title: String? = null,
    val isAnimated: Boolean = true,
    val size: Dp = FunBlocksContentSize.huge,
    val type: PieChartType = PieChartType.Pie,
    val legendColumns: Int = 3
)
