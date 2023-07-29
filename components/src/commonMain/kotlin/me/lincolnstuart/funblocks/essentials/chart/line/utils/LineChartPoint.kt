package me.lincolnstuart.funblocks.essentials.chart.line.utils

import kotlinx.datetime.LocalDate
import java.math.BigDecimal

/**
 * Data class that represents a cartesian point that the path have to visit.
 *
 * @param value [BigDecimal] y coordinate.
 * @param date [LocalDate] x coordinate.
 */
public data class LineChartPoint(
    val value: BigDecimal,
    val date: LocalDate
)
