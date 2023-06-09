package me.lincolnstuart.funblocks.playground.screens.components.chart

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.chart.pie.utils.PieChartPiece
import me.lincolnstuart.funblocks.essentials.chart.pie.PieChart
import me.lincolnstuart.funblocks.essentials.chart.pie.utils.PieChartOptions
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.playground.components.Sample
import java.math.BigDecimal

class PieChartScreen : Screen {

    @Composable
    override fun Content() {
        Sample(
            component = {
                PieChart(
                    data = listOf(
                        PieChartPiece(
                            description = "Data 1",
                            value = BigDecimal("12"),
                            color = FunBlocksColors.Data1.value()
                        ),
                        PieChartPiece(
                            description = "Data 2",
                            value = BigDecimal("3"),
                            color = FunBlocksColors.Data2.value()
                        ),
                        PieChartPiece(
                            description = "Data 3",
                            value = BigDecimal("5"),
                            color = FunBlocksColors.Data3.value()
                        ),
                        PieChartPiece(
                            description = "Data 4",
                            value = BigDecimal("12"),
                            color = FunBlocksColors.Data4.value()
                        ),
                        PieChartPiece(
                            description = "Data 5",
                            value = BigDecimal("3"),
                            color = FunBlocksColors.Data5.value()
                        ),
                        PieChartPiece(
                            description = "Data 6",
                            value = BigDecimal("5"),
                            color = FunBlocksColors.Data6.value()
                        )
                    ),
                    options = PieChartOptions(
                        title = "Pie Chart"
                    )
                )
            }
        ) {}
    }
}
