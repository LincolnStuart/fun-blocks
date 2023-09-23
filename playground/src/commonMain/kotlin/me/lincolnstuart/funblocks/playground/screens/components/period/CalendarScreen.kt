package me.lincolnstuart.funblocks.playground.screens.components.period

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import compose.icons.TablerIcons
import compose.icons.tablericons.ArrowLeft
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import me.lincolnstuart.funblocks.components.core.appbar.utils.AppBarAction
import me.lincolnstuart.funblocks.components.core.appbar.utils.AppBarOptions
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.components.form.radiobutton.RadioButtonGroup
import me.lincolnstuart.funblocks.components.misc.accordion.Accordion
import me.lincolnstuart.funblocks.components.period.calendar.Calendar
import me.lincolnstuart.funblocks.components.period.calendar.utils.CalendarSelectionType
import me.lincolnstuart.funblocks.playground.components.Sample

class CalendarScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        var type by remember {
            mutableStateOf<CalendarSelectionType>(
                CalendarSelectionType.Single(selectedDate = null)
            )
        }
        val options = remember {
            listOf(
                CalendarSelectionType.Single(selectedDate = null),
                CalendarSelectionType.Multiple(selectedDates = emptyList()),
                CalendarSelectionType.Interval(
                    initialSelectedDate = null,
                    finalSelectedDate = null
                )
            )
        }
        Sample(
            appBarOptions = AppBarOptions(
                mainContent = { Text(text = "Calendar", mode = TextMode.Subtitle()) },
                mainAction = AppBarAction(icon = TablerIcons.ArrowLeft, description = null) {
                    navigator.pop()
                }
            ),
            component = {
                Calendar(
                    reference = Clock.System.now().toLocalDateTime(TimeZone.UTC).date,
                    selectionType = type
                ) {
                    type = it
                }
            }
        ) {
            Accordion(title = "Type") {
                RadioButtonGroup(
                    options = options.map { it.javaClass.simpleName },
                    selectedOption = type.javaClass.simpleName,
                    onSelectOption = { className ->
                        val option = options.firstOrNull { it.javaClass.simpleName == className }
                        option?.let { type = option }
                    }
                ) {
                    Text(text = it)
                }
            }
        }
    }
}
