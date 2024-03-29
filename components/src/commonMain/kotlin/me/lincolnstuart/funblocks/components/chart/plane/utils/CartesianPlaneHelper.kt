package me.lincolnstuart.funblocks.components.chart.plane.utils

import kotlinx.datetime.DatePeriod
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDate
import kotlinx.datetime.plus
import kotlinx.datetime.until

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

    fun getRelevantDecimalReferences(points: List<Double>, maxValues: Int): List<Double> {
        val factor = FACTOR.toDouble()
        val difference = ((points.max().minus(points.min())) * (factor)).toInt()
        val leapCount = difference.getIdealCount(maxValues)
        val leapSize = difference / leapCount
        return if (leapCount <= 1) {
            listOf(points.min(), points.max())
        } else {
            buildList {
                var base = points.min()
                add(points.min())
                repeat(leapCount - 1) {
                    base += leapSize / factor
                    add(base)
                }
                add(points.max())
            }
        }
    }

    private tailrec fun Int.getIdealCount(currentCount: Int): Int =
        if (this % currentCount == 0) currentCount else this.getIdealCount(currentCount = currentCount - 1)
}
