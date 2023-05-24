package me.lincolnstuart.funblocks.essentials.chart.line

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.datetime.LocalDate
import me.lincolnstuart.funblocks.chart.line.BasicLineChart
import me.lincolnstuart.funblocks.chart.line.utils.LineChartPath
import me.lincolnstuart.funblocks.chart.line.utils.LineChartPoint
import me.lincolnstuart.funblocks.chart.utils.structure.ChartDecorator
import me.lincolnstuart.funblocks.core.surface.Surface
import me.lincolnstuart.funblocks.essentials.chart.line.utils.LineChartOptions
import me.lincolnstuart.funblocks.essentials.chart.utils.legend.utils.ChartLegendOptions
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing
import java.math.BigDecimal

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
            formatBigDecimal = formatBigDecimal,
            formatLocalDate = formatLocalDate
        )
    }
}

@Preview
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
                                    value = BigDecimal("1"),
                                    date = LocalDate(1990, 10, 12)
                                ),
                                LineChartPoint(
                                    value = BigDecimal("10"),
                                    date = LocalDate(1944, 11, 17)
                                ),
                                LineChartPoint(
                                    value = BigDecimal("7"),
                                    date = LocalDate(1944, 11, 17)
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
