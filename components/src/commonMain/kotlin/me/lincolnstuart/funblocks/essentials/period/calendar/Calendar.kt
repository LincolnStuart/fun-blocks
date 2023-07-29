package me.lincolnstuart.funblocks.essentials.period.calendar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import compose.icons.TablerIcons
import compose.icons.tablericons.ArrowLeft
import compose.icons.tablericons.ArrowRight
import kotlinx.datetime.Clock
import kotlinx.datetime.DatePeriod
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.minus
import kotlinx.datetime.plus
import kotlinx.datetime.todayIn
import me.lincolnstuart.funblocks.essentials.core.icon.Icon
import me.lincolnstuart.funblocks.essentials.core.icon.utils.IconOptions
import me.lincolnstuart.funblocks.essentials.core.icon.utils.IconSize
import me.lincolnstuart.funblocks.essentials.core.spacer.HorizontalSpacer
import me.lincolnstuart.funblocks.essentials.core.surface.Surface
import me.lincolnstuart.funblocks.essentials.core.text.Text
import me.lincolnstuart.funblocks.essentials.core.text.utils.TextMode
import me.lincolnstuart.funblocks.essentials.core.text.utils.regular.RegularWeight
import me.lincolnstuart.funblocks.essentials.core.text.utils.title.TitleSize
import me.lincolnstuart.funblocks.essentials.period.calendar.utils.MonthSnapshot
import me.lincolnstuart.funblocks.essentials.period.utils.ClickableArea
import me.lincolnstuart.funblocks.essentials.period.utils.Indicator
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksInset
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing
import java.time.format.TextStyle
import java.util.Locale

/**
 * Basic calendar based on [LocalDate] that could select only one date.
 *
 * @param reference month and year to setup the first view.
 * @param selectedDate [LocalDate] previous selected.
 * @param locale client locale.
 * @param onSelectDate callback to return which [LocalDate] was selected.
 */
@Composable
public fun Calendar(
    reference: LocalDate,
    selectedDate: LocalDate?,
    locale: Locale = Locale.getDefault(),
    onSelectDate: (LocalDate) -> Unit
) {
    var referenceState by remember(reference) {
        mutableStateOf(reference)
    }
    Column(modifier = Modifier.padding(FunBlocksInset.large)) {
        CalendarHeader(
            reference = referenceState,
            locale = locale,
            onNextMonthClick = { referenceState += DatePeriod(months = 1) },
            onPreviousMonthClick = { referenceState -= DatePeriod(months = 1) }
        )
        CalendarBody(
            locale = locale,
            selectedDate = selectedDate,
            reference = referenceState,
            onSelectDate = onSelectDate
        )
    }
}

/**
 * Calendar body with all dates from reference month chunked by weeks
 *
 * @param locale client locale.
 * @param selectedDate [LocalDate] previous selected.
 * @param reference month and year to setup the first view.
 * @param onSelectDate callback to return which [LocalDate] was selected.
 */
@Composable
private fun CalendarBody(
    locale: Locale,
    selectedDate: LocalDate?,
    reference: LocalDate,
    onSelectDate: (LocalDate) -> Unit
) {
    val monthSnapshot = remember(reference) {
        MonthSnapshot.assemble(reference.year, reference.month)
    }
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        MonthSnapshot.sortedDayOfWeekValues().forEach { day ->
            DayName(description = day.getDisplayName(TextStyle.NARROW, locale))
        }
    }
    monthSnapshot.keys.forEach { key ->
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(FunBlocksSpacing.xxSmall)
        ) {
            monthSnapshot[key]?.forEach { currentDate ->
                Day(
                    selectedDate = selectedDate,
                    currentDate = currentDate,
                    reference = reference,
                    onSelectDate = onSelectDate
                )
            }
        }
    }
}

/**
 * Calendar header with reference month and year, next and previous buttons and all week days names.
 *
 * @param reference month and year to setup the first view.
 * @param locale client locale.
 * @param onNextMonthClick callback to execute an action when next icon is clicked.
 * @param onPreviousMonthClick callback to execute an action when previous icon is clicked.
 */
@Composable
private fun CalendarHeader(
    reference: LocalDate,
    locale: Locale,
    onNextMonthClick: () -> Unit,
    onPreviousMonthClick: () -> Unit
) {
    val yearMonthDescription = remember(reference, locale) {
        "${reference.year} - ${reference.month.getDisplayName(TextStyle.FULL, locale)}"
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = FunBlocksSpacing.xSmall, horizontal = FunBlocksSpacing.xSmall),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = yearMonthDescription, mode = TextMode.Topic())
        }
        ClickableArea(onClick = onPreviousMonthClick) {
            Icon(
                imageVector = TablerIcons.ArrowLeft,
                options = IconOptions(
                    description = null,
                    size = IconSize.Small
                )
            )
        }
        HorizontalSpacer(width = FunBlocksSpacing.small)
        ClickableArea(onClick = onNextMonthClick) {
            Icon(
                imageVector = TablerIcons.ArrowRight,
                options = IconOptions(
                    description = null,
                    size = IconSize.Small
                )
            )
        }
    }
}

/**
 * Cell of day of a week, if it is selected will be indicated.
 *
 * @param selectedDate [LocalDate] previous selected.
 * @param currentDate actual day
 * @param reference month and year to setup the first view.
 * @param onSelectDate callback to return which [LocalDate] was selected.
 */
@Composable
private fun RowScope.Day(
    selectedDate: LocalDate?,
    currentDate: LocalDate,
    reference: LocalDate,
    onSelectDate: (LocalDate) -> Unit
) {
    val isVisible = remember(selectedDate, currentDate) {
        selectedDate == currentDate
    }
    val day = remember(currentDate) {
        currentDate.dayOfMonth.toString()
    }
    val monthComparison = remember(currentDate, reference) {
        currentDate.month.compareTo(reference.month)
    }
    val mode = remember(currentDate, reference) {
        TextMode.Regular(weight = RegularWeight.Light)
    }
    val color = remember(currentDate, reference) {
        if (monthComparison == 0) FunBlocksColors.NeutralDark else FunBlocksColors.NeutralLight
    }
    Indicator(
        onClick = { onSelectDate(currentDate) },
        isVisible = isVisible
    ) {
        CalendarContent {
            Text(
                text = day,
                mode = mode,
                color = color
            )
        }
    }
}

/**
 * Cell of a day week name
 *
 * @param description day week name
 */
@Composable
private fun RowScope.DayName(
    description: String
) {
    CalendarContent {
        Text(
            text = description,
            mode = TextMode.Title(size = TitleSize.H3)
        )
    }
}

/**
 * Generic calendar content item, it represents each cell in calendar component.
 *
 * @param content the content inside
 */
@Composable
private fun RowScope.CalendarContent(
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(
                horizontal = FunBlocksSpacing.xxSmall,
                vertical = FunBlocksSpacing.xSmall
            )
            .weight(1f),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

@Preview
@Composable
private fun CalendarPreview() {
    FunBlocksTheme {
        Surface {
            Calendar(
                reference = Clock.System.todayIn(timeZone = TimeZone.currentSystemDefault()),
                selectedDate = Clock.System.todayIn(timeZone = TimeZone.currentSystemDefault())
            ) {}
        }
    }
}
