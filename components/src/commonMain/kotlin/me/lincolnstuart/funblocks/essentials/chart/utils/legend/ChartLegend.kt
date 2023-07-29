package me.lincolnstuart.funblocks.essentials.chart.utils.legend

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import me.lincolnstuart.funblocks.essentials.chart.utils.legend.utils.ChartLegendOptions
import me.lincolnstuart.funblocks.essentials.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.essentials.core.text.Text
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Basic legend to help the user understand the chart.
 *
 * @param options [ChartLegendOptions] customized legend options.
 */
@Composable
internal fun ChartLegend(
    options: ChartLegendOptions
) = with(options) {
    val columnsNumber = remember(options) {
        if (columns < descriptionAndColor.size) columns else descriptionAndColor.size
    }
    val descriptionAndColorChunked = remember(options) {
        descriptionAndColor.chunked(columnsNumber)
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        descriptionAndColorChunked.forEach { line ->
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(FunBlocksSpacing.xxSmall)
            ) {
                line.forEach { item ->
                    LegendItem(
                        description = item.first,
                        color = item.second
                    )
                }
            }
        }
        VerticalSpacer(height = FunBlocksSpacing.small)
    }
}

@Composable
private fun RowScope.LegendItem(
    description: String,
    color: Color
) {
    Column(
        modifier = Modifier
            .weight(1f)
            .padding(FunBlocksSpacing.xxxSmall),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(FunBlocksSpacing.tiny)
    ) {
        Box(
            modifier = Modifier
                .size(FunBlocksSpacing.small)
                .clip(CircleShape)
                .background(color)
        )
        Text(text = description)
    }
}
