package me.lincolnstuart.funblocks.components.chart.line.utils

import androidx.compose.ui.graphics.Color

/**
 * Data class that represents a grouped cartesian points of a data.
 *
 * @param description data description.
 * @param points grouped cartesian points.
 * @param color data color.
 */
public data class LineChartPath(
    val description: String,
    val points: List<LineChartPoint>,
    val color: Color
)
