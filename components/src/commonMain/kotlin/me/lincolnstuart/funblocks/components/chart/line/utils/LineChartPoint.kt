package me.lincolnstuart.funblocks.components.chart.line.utils

import kotlinx.datetime.LocalDate

/**
 * Data class that represents a cartesian point that the path have to visit.
 *
 * @param value [Double] y coordinate.
 * @param date [LocalDate] x coordinate.
 */
public data class LineChartPoint(
    val value: Double,
    val date: LocalDate
)
