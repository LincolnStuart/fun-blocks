package me.lincolnstuart.funblocks.essentials.chart.bar

import androidx.compose.runtime.Composable
import me.lincolnstuart.funblocks.essentials.chart.bar.utils.BarChartOptions
import me.lincolnstuart.funblocks.essentials.chart.bar.utils.BarChartValue
import me.lincolnstuart.funblocks.essentials.chart.utils.legend.utils.ChartLegendOptions
import me.lincolnstuart.funblocks.essentials.chart.utils.structure.ChartDecorator

@Composable
public fun BarChart(
    values: List<BarChartValue>,
    options: BarChartOptions
) = with(options) {
    val barColor = color.value()
    ChartDecorator(
        title = title,
        legendOptions = ChartLegendOptions(
            columns = 1,
            descriptionAndColor = listOf(description.orEmpty() to barColor)
        )
    ) {
        BasicBarChart(
            values = values,
            height = height,
            color = barColor,
            isAnimated = isAnimated,
            formatBigDecimal = formatBigDecimal,
            formatLocalDate = formatLocalDate
        )
    }
}