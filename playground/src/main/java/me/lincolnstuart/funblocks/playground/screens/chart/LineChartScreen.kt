package me.lincolnstuart.funblocks.playground.screens.chart

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.screen.Screen
import kotlinx.datetime.LocalDate
import kotlinx.datetime.toJavaLocalDate
import me.lincolnstuart.funblocks.chart.line.utils.LineChartPath
import me.lincolnstuart.funblocks.chart.line.utils.LineChartPoint
import me.lincolnstuart.funblocks.essentials.chart.line.LineChart
import me.lincolnstuart.funblocks.essentials.chart.line.utils.LineChartOptions
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import me.lincolnstuart.funblocks.playground.components.Sample
import java.math.BigDecimal
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
                                    value = BigDecimal("300"),
                                    LocalDate(year = 1990, monthNumber = 10, dayOfMonth = 12)
                                ),
                                LineChartPoint(
                                    value = BigDecimal("100000"),
                                    LocalDate(year = 2020, monthNumber = 12, dayOfMonth = 5)
                                ),
                                LineChartPoint(
                                    value = BigDecimal("70000"),
                                    LocalDate(year = 1944, monthNumber = 11, dayOfMonth = 17)
                                )
                            ),
                            color = FunBlocksColors.Data1.value()
                        ),
                        LineChartPath(
                            description = "Line 1",
                            points = listOf(
                                LineChartPoint(
                                    value = BigDecimal("30000"),
                                    LocalDate(year = 1990, monthNumber = 10, dayOfMonth = 12)
                                ),
                                LineChartPoint(
                                    value = BigDecimal("19000"),
                                    LocalDate(year = 2020, monthNumber = 12, dayOfMonth = 5)
                                ),
                                LineChartPoint(
                                    value = BigDecimal("7500"),
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
