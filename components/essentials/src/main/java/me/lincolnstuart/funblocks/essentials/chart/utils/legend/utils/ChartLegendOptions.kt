package me.lincolnstuart.funblocks.essentials.chart.utils.legend.utils

import androidx.compose.ui.graphics.Color

/**
 * Data class to customize the chart legend.
 *
 * @param columns number of columns per line.
 * @param descriptionAndColor pair of identifiers chart data.
 */
internal data class ChartLegendOptions(
    val columns: Int,
    val descriptionAndColor: List<Pair<String, Color>>
)
