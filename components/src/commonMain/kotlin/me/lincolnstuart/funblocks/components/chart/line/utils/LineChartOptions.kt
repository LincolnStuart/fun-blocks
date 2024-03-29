package me.lincolnstuart.funblocks.components.chart.line.utils

import androidx.compose.ui.unit.Dp
import kotlinx.datetime.LocalDate
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize

/**
 * Data class to customize the line chart.
 *
 * @param title chart description.
 * @param isAnimated if starts with animation.
 * @param height it is recommended to use [FunBlocksContentSize].
 * @param legendColumns of columns per line on the legend.
 * @param formatValue to string from [Double].
 * @param formatLocalDate to string from [LocalDate].
 */
public data class LineChartOptions(
    val title: String? = null,
    val isAnimated: Boolean = true,
    val height: Dp = FunBlocksContentSize.huge,
    val legendColumns: Int = 3,
    val formatValue: (Double) -> String = { it.toString() },
    val formatLocalDate: (LocalDate) -> String = { it.toString() }
)
