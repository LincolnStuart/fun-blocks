package me.lincolnstuart.funblocks.components.chart.bar.utils

import kotlinx.datetime.LocalDate

/**
 * Data class that a represents the cartesian point that the bar have to grow up until.
 *
 * @param value [Double] y coordinate.
 * @param date [LocalDate] x coordinate.
 */
public class BarChartValue(
    val value: Double,
    val date: LocalDate
)
