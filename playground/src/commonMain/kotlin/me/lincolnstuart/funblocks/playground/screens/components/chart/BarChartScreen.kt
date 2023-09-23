package me.lincolnstuart.funblocks.playground.screens.components.chart

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import compose.icons.TablerIcons
import compose.icons.tablericons.ArrowLeft
import kotlinx.datetime.LocalDate
import me.lincolnstuart.funblocks.components.chart.bar.BarChart
import me.lincolnstuart.funblocks.components.chart.bar.utils.BarChartOptions
import me.lincolnstuart.funblocks.components.chart.bar.utils.BarChartValue
import me.lincolnstuart.funblocks.components.core.appbar.utils.AppBarAction
import me.lincolnstuart.funblocks.components.core.appbar.utils.AppBarOptions
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import me.lincolnstuart.funblocks.playground.components.Sample

class BarChartScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Sample(
            appBarOptions = AppBarOptions(
                mainContent = { Text(text = "BarChart", mode = TextMode.Subtitle()) },
                mainAction = AppBarAction(icon = TablerIcons.ArrowLeft, description = null) {
                    navigator.pop()
                }
            ),
            component = {
                BarChart(
                    values =
                    listOf(
                        BarChartValue(
                            value = 300.0,
                            date = LocalDate(year = 1990, monthNumber = 10, dayOfMonth = 12)
                        ),
                        BarChartValue(
                            value = 500.0,
                            date = LocalDate(year = 2020, monthNumber = 12, dayOfMonth = 5)

                        ),
                        BarChartValue(
                            value = 400.0,
                            date = LocalDate(year = 2023, monthNumber = 5, dayOfMonth = 15)
                        )
                    ),
                    options = BarChartOptions(
                        title = "Bar Chart",
                        description = "Description",
                        height = FunBlocksContentSize.xxxHuge,
                        isAnimated = true
                    )
                )
            }
        ) {}
    }
}
