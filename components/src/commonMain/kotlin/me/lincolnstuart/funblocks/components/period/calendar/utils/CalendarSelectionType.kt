package me.lincolnstuart.funblocks.components.period.calendar.utils

import kotlinx.datetime.LocalDate

public sealed class CalendarSelectionType {
    abstract fun getSelectionIndicatorStyle(date: LocalDate): CalendarSelectionIndicatorStyle
    abstract fun selectDate(date: LocalDate): CalendarSelectionType

    data class Single(val selectedDate: LocalDate?) : CalendarSelectionType() {
        override fun getSelectionIndicatorStyle(date: LocalDate): CalendarSelectionIndicatorStyle =
            if (selectedDate == date) {
                CalendarSelectionIndicatorStyle.Regular
            } else {
                CalendarSelectionIndicatorStyle.None
            }

        override fun selectDate(date: LocalDate): CalendarSelectionType =
            if (date == selectedDate) {
                copy(selectedDate = null)
            } else {
                copy(selectedDate = date)
            }
    }

    data class Multiple(val selectedDates: List<LocalDate>) : CalendarSelectionType() {
        override fun getSelectionIndicatorStyle(date: LocalDate): CalendarSelectionIndicatorStyle =
            if (selectedDates.contains(date)) {
                CalendarSelectionIndicatorStyle.Regular
            } else {
                CalendarSelectionIndicatorStyle.None
            }

        override fun selectDate(date: LocalDate): CalendarSelectionType {
            val datesUpdating = selectedDates.toMutableList()
            if (date in selectedDates) {
                datesUpdating.remove(date)
            } else {
                datesUpdating.add(date)
            }
            return copy(selectedDates = datesUpdating)
        }
    }

    data class Interval(
        val initialSelectedDate: LocalDate?,
        val finalSelectedDate: LocalDate?
    ) : CalendarSelectionType() {
        override fun getSelectionIndicatorStyle(date: LocalDate): CalendarSelectionIndicatorStyle =
            when {
                initialSelectedDate != null && initialSelectedDate == finalSelectedDate ->
                    if (date == initialSelectedDate) {
                        CalendarSelectionIndicatorStyle.Regular
                    } else {
                        CalendarSelectionIndicatorStyle.None
                    }

                initialSelectedDate != null && finalSelectedDate != null ->
                    if (date in initialSelectedDate..finalSelectedDate) {
                        when (date) {
                            initialSelectedDate -> CalendarSelectionIndicatorStyle.Start
                            finalSelectedDate -> CalendarSelectionIndicatorStyle.End
                            else -> CalendarSelectionIndicatorStyle.Between
                        }
                    } else {
                        CalendarSelectionIndicatorStyle.None
                    }

                initialSelectedDate != null ->
                    if (date == initialSelectedDate) {
                        CalendarSelectionIndicatorStyle.Regular
                    } else {
                        CalendarSelectionIndicatorStyle.None
                    }

                else ->
                    if (date == finalSelectedDate) {
                        CalendarSelectionIndicatorStyle.Regular
                    } else {
                        CalendarSelectionIndicatorStyle.None
                    }
            }

        override fun selectDate(date: LocalDate): CalendarSelectionType =
            when {
                initialSelectedDate == null && finalSelectedDate == null ->
                    copy(initialSelectedDate = date)

                finalSelectedDate == null ->
                    copy(finalSelectedDate = date)

                initialSelectedDate == null ->
                    if (date < finalSelectedDate) {
                        copy(initialSelectedDate = date)
                    } else {
                        copy(initialSelectedDate = finalSelectedDate, finalSelectedDate = date)
                    }

                date < initialSelectedDate ->
                    copy(initialSelectedDate = date)

                initialSelectedDate == finalSelectedDate && initialSelectedDate == date ->
                    copy(initialSelectedDate = null, finalSelectedDate = null)

                else ->
                    copy(finalSelectedDate = date)
            }
    }
}
