package me.lincolnstuart.funblocks.playground.screens.components.chart

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.screen.Screen
import kotlinx.datetime.LocalDate
import kotlinx.datetime.toJavaLocalDate
import me.lincolnstuart.funblocks.essentials.chart.line.LineChart
import me.lincolnstuart.funblocks.essentials.chart.line.utils.LineChartOptions
import me.lincolnstuart.funblocks.essentials.chart.line.utils.LineChartPath
import me.lincolnstuart.funblocks.essentials.chart.line.utils.LineChartPoint
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import me.lincolnstuart.funblocks.playground.components.Sample
import java.time.format.DateTimeFormatter

class LineChartScreen : Screen {

    @Composable
    override fun Content() {
        val dateFormat = remember { DateTimeFormatter.ofPattern("dd/MM/yyyy") }
        Sample(
            component = {
                LineChart(
                    paths = listOf(
                        LineChartPath(
                            description = "Line 1",
                            points = listOf(
                                LineChartPoint(
                                    value = 300.0,
                                    LocalDate(year = 1990, monthNumber = 10, dayOfMonth = 12)
                                ),
                                LineChartPoint(
                                    value = 100000.0,
                                    LocalDate(year = 2020, monthNumber = 12, dayOfMonth = 5)
                                ),
                                LineChartPoint(
                                    value = 70000.0,
                                    LocalDate(year = 1944, monthNumber = 11, dayOfMonth = 17)
                                )
                            ),
                            color = FunBlocksColors.Data1.value()
                        ),
                        LineChartPath(
                            description = "Line 1",
                            points = listOf(
                                LineChartPoint(
                                    value = 30000.0,
                                    LocalDate(year = 1990, monthNumber = 10, dayOfMonth = 12)
                                ),
                                LineChartPoint(
                                    value = 19000.0,
                                    LocalDate(year = 2020, monthNumber = 12, dayOfMonth = 5)
                                ),
                                LineChartPoint(
                                    value = 7500.0,
                                    LocalDate(year = 1944, monthNumber = 11, dayOfMonth = 17)
                                )
                            ),
                            color = FunBlocksColors.Data2.value()
                        )
                    ),
                    options = LineChartOptions(
                        title = "Line chart",
                        height = FunBlocksContentSize.xxxHuge,
                        formatLocalDate = {
                            it.toJavaLocalDate().format(dateFormat)
                        }
                    )
                )
            }
        ) {}
    }
}
