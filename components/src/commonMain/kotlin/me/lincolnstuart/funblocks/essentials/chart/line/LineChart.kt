package me.lincolnstuart.funblocks.essentials.chart.line

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.datetime.LocalDate
import me.lincolnstuart.funblocks.essentials.chart.line.utils.LineChartOptions
import me.lincolnstuart.funblocks.essentials.chart.line.utils.LineChartPath
import me.lincolnstuart.funblocks.essentials.chart.line.utils.LineChartPoint
import me.lincolnstuart.funblocks.essentials.chart.utils.legend.utils.ChartLegendOptions
import me.lincolnstuart.funblocks.essentials.chart.utils.structure.ChartDecorator
import me.lincolnstuart.funblocks.essentials.core.surface.Surface
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Line chart that draws paths in a cartesian plane based on a time line and put title and legend.
 *
 * @param paths list of [LineChartPath] to draw in a cartesian plane.
 * @param options [LineChartOptions] options to customize the line chart.
 */
@Composable
public fun LineChart(
    paths: List<LineChartPath>,
    options: LineChartOptions = LineChartOptions()
) = with(options) {
    ChartDecorator(
        title = title,
        legendOptions = ChartLegendOptions(
            columns = legendColumns,
            descriptionAndColor = paths.map { path ->
                path.description to path.color
            }
        )
    ) {
        BasicLineChart(
            paths = paths,
            height = height,
            isAnimated = isAnimated,
            formatValue = formatValue,
            formatLocalDate = formatLocalDate
        )
    }
}

// @Preview
@Composable
private fun LineChartPreview() {
    FunBlocksTheme {
        Surface {
            Box(modifier = Modifier.padding(FunBlocksSpacing.medium)) {
                LineChart(
                    paths = listOf(
                        LineChartPath(
                            description = "Line 1",
                            points = listOf(
                                LineChartPoint(
                                    value = 1.0,
                                    date = LocalDate(year = 1990, monthNumber = 10, dayOfMonth = 12)
                                ),
                                LineChartPoint(
                                    value = 10.0,
                                    date = LocalDate(year = 1944, monthNumber = 11, dayOfMonth = 17)
                                ),
                                LineChartPoint(
                                    value = 7.0,
                                    date = LocalDate(year = 1944, monthNumber = 11, dayOfMonth = 17)
                                )
                            ),
                            color = FunBlocksColors.Data1.value()
                        )
                    ),
                    options = LineChartOptions(title = "Title", isAnimated = false)
                )
            }
        }
    }
}
