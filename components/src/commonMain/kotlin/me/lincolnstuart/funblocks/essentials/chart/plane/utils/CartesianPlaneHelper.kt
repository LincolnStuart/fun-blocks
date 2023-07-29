package me.lincolnstuart.funblocks.essentials.chart.plane.utils

import kotlinx.datetime.DatePeriod
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDate
import kotlinx.datetime.plus
import kotlinx.datetime.until
import java.math.BigDecimal

/**
 * Object that provides relevant values to draw a cartesian plane.
 */
internal object CartesianPlaneHelper {

    private const val FACTOR: Int = 1000

    fun getRelevantDateReferences(points: List<LocalDate>, maxValues: Int): List<LocalDate> {
        val daysCount = points.min().until(other = points.max(), unit = DateTimeUnit.DAY)
        val leapCount = daysCount.getIdealCount(currentCount = maxValues)
        val leapSize = daysCount / leapCount
        return if (leapCount <= 1) {
            listOf(points.min(), points.max())
        } else {
            buildList {
                var base = points.min()
                add(points.min())
                repeat(leapCount - 1) {
                    base += DatePeriod(days = leapSize)
                    add(base)
                }
                add(points.max())
            }
        }
    }

    fun getRelevantDecimalReferences(points: List<BigDecimal>, maxValues: Int): List<BigDecimal> {
        val factor = BigDecimal(FACTOR)
        val difference = (points.max().minus(points.min())).multiply(factor).toInt()
        val leapCount = difference.getIdealCount(maxValues)
        val leapSize = difference / leapCount
        return if (leapCount <= 1) {
            listOf(points.min(), points.max())
        } else {
            buildList {
                var base = points.min()
                add(points.min())
                repeat(leapCount - 1) {
                    base = base.plus(BigDecimal(leapSize).divide(factor))
                    add(base)
                }
                add(points.max())
            }
        }
    }

    private tailrec fun Int.getIdealCount(currentCount: Int): Int =
        if (this % currentCount == 0) currentCount else this.getIdealCount(currentCount = currentCount - 1)
}
