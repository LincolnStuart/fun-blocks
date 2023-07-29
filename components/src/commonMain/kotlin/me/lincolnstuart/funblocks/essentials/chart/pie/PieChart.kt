package me.lincolnstuart.funblocks.essentials.chart.pie

import androidx.compose.runtime.Composable
import me.lincolnstuart.funblocks.essentials.chart.pie.utils.PieChartOptions
import me.lincolnstuart.funblocks.essentials.chart.pie.utils.PieChartPiece
import me.lincolnstuart.funblocks.essentials.chart.utils.legend.utils.ChartLegendOptions
import me.lincolnstuart.funblocks.essentials.chart.utils.structure.ChartDecorator

/**
 * Pie chart that could be a donut as well.
 *
 * @param data map of description and value of a portion.
 * @param options [PieChartOptions] options to customize the pie chart.
 */
@Composable
fun PieChart(
    data: List<PieChartPiece>,
    options: PieChartOptions = PieChartOptions()
) = with(options) {
    ChartDecorator(
        title = options.title,
        legendOptions = ChartLegendOptions(
            columns = legendColumns,
            descriptionAndColor = data.map { piece ->
                piece.description to piece.color
            }
        )
    ) {
        BasicPieChart(
            data = data,
            size = size,
            isAnimated = isAnimated,
            type = type
        )
    }
}
