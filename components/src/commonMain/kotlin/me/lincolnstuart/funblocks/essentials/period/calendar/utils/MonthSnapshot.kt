package me.lincolnstuart.funblocks.essentials.period.calendar.utils

import kotlinx.datetime.DatePeriod
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.LocalDate
import kotlinx.datetime.Month
import kotlinx.datetime.minus
import kotlinx.datetime.plus
import kotlinx.datetime.until

/**
 * Object that provides snapshots of week names and weeks of month based on the preset year month.
 */
internal object MonthSnapshot {

    /**
     * Provide a map with sorted weeks filled with all [LocalDate]s between start and and of the
     * month.
     *
     * @param year reference year.
     * @param month reference month.
     */
    fun assemble(year: Int, month: Month): Map<Int, List<LocalDate>> {
        val baseDate = LocalDate(year = year, month = month, dayOfMonth = 1)
        val start = baseDate.let(MonthSnapshot::adjustWeekStart)
        val end = LocalDate(
            year = year,
            month = month,
            dayOfMonth = baseDate.atEndOfMonth().dayOfMonth
        )
        val weekCount = start.until(other = end, unit = DateTimeUnit.WEEK) + 1
        return buildMap {
            var weekStart = start
            repeat(weekCount) { index ->
                val datesOnAWeek = getAllDatesOnAWeek(weekStart)
                put(key = index, value = datesOnAWeek)
                weekStart = datesOnAWeek.last() + DatePeriod(days = 1)
            }
        }
    }

    /**
     * Provides all [DayOfWeek] from sunday to saturday.
     */
    fun sortedDayOfWeekValues(): List<DayOfWeek> =
        listOf(
            DayOfWeek.SUNDAY,
            DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY,
            DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY,
            DayOfWeek.FRIDAY,
            DayOfWeek.SATURDAY
        )

    /**
     * Adjust start [LocalDate] to get the first week day of the week. E.g. if the start date is an
     * wednesday, it returns last sunday date.
     *
     * @param date start date.
     */
    private fun adjustWeekStart(date: LocalDate): LocalDate {
        val factor = date.dayOfWeek.ordinal * -1
        return date + DatePeriod(days = factor)
    }

    /**
     * Calculates the last day of the reference month
     */
    private fun LocalDate.atEndOfMonth(): LocalDate = this + DatePeriod(months = 1) - DatePeriod(days = 1)

    /**
     * Returns all 7 later dates from an start date.
     *
     * @param first start date
     */
    private fun getAllDatesOnAWeek(first: LocalDate): List<LocalDate> = buildList {
        var currentDate = first
        repeat(times = 7) {
            add(currentDate)
            currentDate += DatePeriod(days = 1)
        }
    }
}
