package me.lincolnstuart.funblocks.essentials.chart.bar.utils

import kotlinx.datetime.LocalDate
import java.math.BigDecimal

/**
 * Data class that a represents the cartesian point that the bar have to grow up until.
 *
 * @param value [BigDecimal] y coordinate.
 * @param date [LocalDate] x coordinate.
 */
public class BarChartValue(
    val value: BigDecimal,
    val date: LocalDate
)
