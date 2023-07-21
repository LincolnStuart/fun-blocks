package me.lincolnstuart.funblocks.chart.plane.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import me.lincolnstuart.funblocks.foundation.ui.token.content.border.FunBlocksBorderWidth

/**
 * Data class that customize a cartesian plane.
 *
 * @param lineColor [Color].
 * @param lineWidth it is recommended to use [FunBlocksBorderWidth].
 * @param space [CartesianPlaneSpace] that represents the usable area.
 * @param isVerticalLinesVisible if vertical lines are visible.
 * @param textStyle [TextStyle] it recommended to use TextMode to generate the style.
 * @param referenceValues [CartesianPlaneReferenceValues] relevant marks to draw on cartesian plane.
 * @param formatHorizontalReferenceValue to string from horizontal values.
 * @param formatVerticalReferenceValue to string from vertical values.
 */
internal data class CartesianPlaneOptions<V, H>(
    val lineColor: Color,
    val lineWidth: Dp,
    val space: CartesianPlaneSpace,
    val isVerticalLinesVisible: Boolean,
    val textStyle: TextStyle,
    val referenceValues: CartesianPlaneReferenceValues<V, H>,
    val formatHorizontalReferenceValue: (H) -> String,
    val formatVerticalReferenceValue: (V) -> String
)
