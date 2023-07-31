package me.lincolnstuart.funblocks.playground.screens.components.period

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import me.lincolnstuart.funblocks.essentials.period.calendar.Calendar
import me.lincolnstuart.funblocks.playground.components.Sample

class CalendarScreen : Screen {

    @Composable
    override fun Content() {
        var selectedDate by remember {
            mutableStateOf<LocalDate?>(null)
        }
        Sample(
            component = {
                Calendar(
                    reference = Clock.System.now().toLocalDateTime(TimeZone.UTC).date,
                    selectedDate = selectedDate
                ) {
                    selectedDate = it
                }
            }
        ) {}
    }
}
