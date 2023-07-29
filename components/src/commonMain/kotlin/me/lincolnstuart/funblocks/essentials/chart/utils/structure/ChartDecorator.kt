package me.lincolnstuart.funblocks.essentials.chart.utils.structure

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import me.lincolnstuart.funblocks.essentials.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.essentials.core.text.Text
import me.lincolnstuart.funblocks.essentials.core.text.utils.TextMode
import me.lincolnstuart.funblocks.essentials.chart.utils.legend.ChartLegend
import me.lincolnstuart.funblocks.essentials.chart.utils.legend.utils.ChartLegendOptions
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Chart shell that includes a chart between title and legend.
 *
 * @param title chart description.
 * @param legendOptions customized legend options.
 * @param chart a chart composable.
 */
@Composable
internal fun ChartDecorator(
    title: String?,
    legendOptions: ChartLegendOptions,
    chart: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        title?.let {
            Text(text = title, mode = TextMode.Title())
            VerticalSpacer(height = FunBlocksSpacing.medium)
        }
        chart()
        VerticalSpacer(height = FunBlocksSpacing.medium)
        ChartLegend(options = legendOptions)
    }
}
