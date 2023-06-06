package me.lincolnstuart.funblocks.sample.screens.chart

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import kotlinx.datetime.LocalDate
import me.lincolnstuart.funblocks.chart.bar.utils.BarChartValue
import me.lincolnstuart.funblocks.essentials.chart.bar.BarChart
import me.lincolnstuart.funblocks.essentials.chart.bar.utils.BarChartOptions
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import me.lincolnstuart.funblocks.sample.components.Playground
import java.math.BigDecimal

class BarChartScreen : Screen {

    @Composable
    override fun Content() {
        Playground(
            component = {
                BarChart(
                    values =
                    listOf(
                        BarChartValue(
                            value = BigDecimal("300"),
                            date = LocalDate(year = 1990, monthNumber = 10, dayOfMonth = 12)
                        ),
                        BarChartValue(
                            value = BigDecimal("500"),
                            date = LocalDate(year = 2020, monthNumber = 12, dayOfMonth = 5)

                        ),
                        BarChartValue(
                            value = BigDecimal("400"),
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
