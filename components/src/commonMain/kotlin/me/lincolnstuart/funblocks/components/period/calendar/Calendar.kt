package me.lincolnstuart.funblocks.components.period.calendar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import me.lincolnstuart.funblocks.components.core.icon.Icon
import me.lincolnstuart.funblocks.components.core.icon.utils.IconOptions
import me.lincolnstuart.funblocks.components.core.icon.utils.IconSize
import me.lincolnstuart.funblocks.components.core.spacer.HorizontalSpacer
import me.lincolnstuart.funblocks.components.core.surface.Surface
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.components.core.text.utils.regular.RegularWeight
import me.lincolnstuart.funblocks.components.core.text.utils.title.TitleSize
import me.lincolnstuart.funblocks.components.period.calendar.utils.CalendarSelectionIndicatorStyle
import me.lincolnstuart.funblocks.components.period.calendar.utils.CalendarSelectionType
import me.lincolnstuart.funblocks.components.period.calendar.utils.MonthSnapshot
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.border.FunBlocksBorderWidth
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Basic calendar based on [LocalDate] that could select only one date.
 *
 * @param reference month and year to setup the first view.
 * @param selectionType [CalendarSelectionType] with previous selected.
 * @param onSelectDate callback to return which [LocalDate] was selected.
 */
@Composable
public fun Calendar(
    reference: LocalDate,
    selectionType: CalendarSelectionType,
    onSelectDate: (type: CalendarSelectionType) -> Unit
) {
    var referenceState by remember(reference) {
        mutableStateOf(reference)
    }
    Column {
        CalendarHeader(
            reference = referenceState,
            onNextMonthClick = { referenceState += DatePeriod(months = 1) },
            onPreviousMonthClick = { referenceState -= DatePeriod(months = 1) }
        )
        CalendarBody(
            selectionType = selectionType,
            reference = referenceState,
            onSelectDate = onSelectDate
        )
    }
}

/**
 * Calendar body with all dates from reference month chunked by weeks
 *
 * @param selectionType [CalendarSelectionType] with previous selected.
 * @param reference month and year to setup the first view.
 * @param onSelectDate callback to return which [LocalDate] was selected.
 */
@Composable
private fun CalendarBody(
    selectionType: CalendarSelectionType,
    reference: LocalDate,
    onSelectDate: (type: CalendarSelectionType) -> Unit
) {
    val monthSnapshot = remember(reference) {
        MonthSnapshot.assemble(reference.year, reference.month)
    }
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        MonthSnapshot.sortedDayOfWeekValues().forEach { day ->
            DayName(description = day.name.first().uppercase())
        }
    }
    monthSnapshot.keys.forEach { key ->
        Row(modifier = Modifier.fillMaxWidth()) {
            monthSnapshot[key]?.forEach { currentDate ->
                Day(
                    selectionType = selectionType,
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
 * @param onNextMonthClick callback to execute an action when next icon is clicked.
 * @param onPreviousMonthClick callback to execute an action when previous icon is clicked.
 */
@Composable
private fun CalendarHeader(
    reference: LocalDate,
    onNextMonthClick: () -> Unit,
    onPreviousMonthClick: () -> Unit
) {
    val yearMonthDescription = remember(reference) {
        "${reference.year} - ${reference.month.name}"
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
        CalendarClickableArea(onClick = onPreviousMonthClick) {
            Icon(
                imageVector = TablerIcons.ArrowLeft,
                options = IconOptions(
                    description = null,
                    size = IconSize.Small
                )
            )
        }
        HorizontalSpacer(width = FunBlocksSpacing.small)
        CalendarClickableArea(onClick = onNextMonthClick) {
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
 * @param selectionType [CalendarSelectionType] with previous selected.
 * @param currentDate actual day
 * @param reference month and year to setup the first view.
 * @param onSelectDate callback to return which [LocalDate] was selected.
 */
@Composable
private fun RowScope.Day(
    selectionType: CalendarSelectionType,
    currentDate: LocalDate,
    reference: LocalDate,
    onSelectDate: (type: CalendarSelectionType) -> Unit
) {
    val selectionIndicatorStyle = remember(selectionType, currentDate) {
        selectionType.getSelectionIndicatorStyle(currentDate)
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
    val color = remember(currentDate, reference, selectionIndicatorStyle) {
        when {
            selectionIndicatorStyle != CalendarSelectionIndicatorStyle.None -> FunBlocksColors.PrimaryContrast
            monthComparison == 0 -> FunBlocksColors.NeutralDark
            else -> FunBlocksColors.NeutralLight
        }
    }
    SelectionIndicator(
        onClick = { onSelectDate(selectionType.selectDate(currentDate)) },
        selectionIndicatorStyle = selectionIndicatorStyle
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

/**
 * Generic clickable area.
 *
 * @param onClick callback to execute an action when click is performed.
 * @param content the content inside.
 */
@Composable
private fun CalendarClickableArea(
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

/**
 * Indicator that paint a background behind the content when it is visible
 *
 * @param onClick callback to execute an action when click is performed.
 * @param selectionIndicatorStyle [CalendarSelectionIndicatorStyle] with current styles to apply.
 * @param content the content inside.
 */
@Composable
private fun RowScope.SelectionIndicator(
    onClick: () -> Unit,
    selectionIndicatorStyle: CalendarSelectionIndicatorStyle,
    content: @Composable () -> Unit
) = with(selectionIndicatorStyle) {
    Box(
        modifier = Modifier
            .weight(1f)
            .clip(shape)
            .background(backgroundColor.value())
            .border(
                border = BorderStroke(
                    width = FunBlocksBorderWidth.regular,
                    color = borderColor.value()
                )
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

// @Preview
@Composable
private fun CalendarPreview() {
    FunBlocksTheme {
        Surface {
            Calendar(
                reference = Clock.System.todayIn(timeZone = TimeZone.currentSystemDefault()),
                selectionType = CalendarSelectionType.Single(
                    selectedDate = Clock.System.todayIn(timeZone = TimeZone.currentSystemDefault())
                )
            ) {}
        }
    }
}
