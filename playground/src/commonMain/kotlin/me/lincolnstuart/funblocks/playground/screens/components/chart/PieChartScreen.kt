package me.lincolnstuart.funblocks.playground.screens.components.chart

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.components.chart.pie.PieChart
import me.lincolnstuart.funblocks.components.chart.pie.utils.PieChartOptions
import me.lincolnstuart.funblocks.components.chart.pie.utils.PieChartPiece
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.playground.components.Sample

class PieChartScreen : Screen {

    @Composable
    override fun Content() {
        Sample(
            component = {
                PieChart(
                    data = listOf(
                        PieChartPiece(
                            description = "Data 1",
                            value = 12.0,
                            color = FunBlocksColors.Data1.value()
                        ),
                        PieChartPiece(
                            description = "Data 2",
                            value = 3.0,
                            color = FunBlocksColors.Data2.value()
                        ),
                        PieChartPiece(
                            description = "Data 3",
                            value = 5.0,
                            color = FunBlocksColors.Data3.value()
                        ),
                        PieChartPiece(
                            description = "Data 4",
                            value = 12.0,
                            color = FunBlocksColors.Data4.value()
                        ),
                        PieChartPiece(
                            description = "Data 5",
                            value = 3.0,
                            color = FunBlocksColors.Data5.value()
                        ),
                        PieChartPiece(
                            description = "Data 6",
                            value = 5.0,
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
