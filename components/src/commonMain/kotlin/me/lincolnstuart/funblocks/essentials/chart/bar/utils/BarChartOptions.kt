package me.lincolnstuart.funblocks.essentials.chart.bar.utils

import androidx.compose.ui.unit.Dp
import kotlinx.datetime.LocalDate
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize

/**
 * Data class to customize the bar chart.
 *
 * @param title chart description.
 * @param description legend description.
 * @param isAnimated if starts with animation.
 * @param height it is recommended to use [FunBlocksContentSize].
 * @param color bar color.
 * @param formatValue to string from [Double].
 * @param formatLocalDate to string from [LocalDate].
 */
public data class BarChartOptions(
    val title: String? = null,
    val description: String? = null,
    val isAnimated: Boolean = true,
    val height: Dp = FunBlocksContentSize.huge,
    val color: FunBlocksColors = FunBlocksColors.Data1,
    val formatValue: (Double) -> String = { it.toString() },
    val formatLocalDate: (LocalDate) -> String = { it.toString() }
)
