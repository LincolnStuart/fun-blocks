package me.lincolnstuart.funblocks.components.chart.bar

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.Dp
import kotlinx.datetime.LocalDate
import me.lincolnstuart.funblocks.components.chart.bar.utils.BarChartValue
import me.lincolnstuart.funblocks.components.chart.plane.CartesianPlane
import me.lincolnstuart.funblocks.components.chart.plane.utils.CartesianPlaneHelper
import me.lincolnstuart.funblocks.components.chart.plane.utils.CartesianPlaneOptions
import me.lincolnstuart.funblocks.components.chart.plane.utils.CartesianPlaneReferenceValues
import me.lincolnstuart.funblocks.components.chart.plane.utils.CartesianPlaneSpace
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.foundation.ui.theme.LocalTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.color.alpha.FunBlocksAlpha
import me.lincolnstuart.funblocks.foundation.ui.token.content.border.FunBlocksBorderWidth
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import me.lincolnstuart.funblocks.foundation.ui.token.font.FunBlocksFontSize

/**
 * Bar chart that draws bars in a cartesian plane based on a time line.
 *
 * @param values list of [BarChartValue] to draw in a cartesian plane.
 * @param height it is recommended to use [FunBlocksContentSize].
 * @param isAnimated if starts with animation.
 * @param formatValue to string from [Double].
 * @param formatLocalDate to string from [LocalDate].
 */
@OptIn(ExperimentalTextApi::class)
@Composable
internal fun BasicBarChart(
    values: List<BarChartValue>,
    height: Dp = FunBlocksContentSize.huge,
    color: Color,
    isAnimated: Boolean = false,
    formatValue: (Double) -> String = { it.toString() },
    formatLocalDate: (LocalDate) -> String = { it.toString() }
) {
    val textMeasurer = rememberTextMeasurer()
    val animationProgress = rememberAnimationProgress(isAnimated)
    val lineColor = FunBlocksColors.Border.value()
    val textColor = FunBlocksColors.Neutral.value()
    val mode = remember { TextMode.Regular() }
    val theme = LocalTheme.current
    Spacer(
        modifier = androidx.compose.ui.Modifier
            .height(height)
            .fillMaxWidth()
            .drawWithCache {
                val cartesianPlaneSpace = CartesianPlaneSpace(
                    height = height.toPx() - FunBlocksFontSize.xLarge.toPx(),
                    width = size.width
                )
                onDrawBehind {
                    CartesianPlane(
                        drawScope = this,
                        textMeasurer = textMeasurer,
                        options = CartesianPlaneOptions(
                            lineColor = lineColor,
                            lineWidth = FunBlocksBorderWidth.regular,
                            space = cartesianPlaneSpace,
                            isVerticalLinesVisible = false,
                            textStyle = TextStyle(
                                fontFamily = theme.fontFamily,
                                fontWeight = mode.fontWeight,
                                fontSize = mode.fontSize,
                                color = textColor
                            ),
                            referenceValues = CartesianPlaneReferenceValues(
                                horizontalValues = CartesianPlaneHelper.getRelevantDateReferences(
                                    points = values.map { it.date },
                                    maxValues = 4
                                ),
                                verticalValues = CartesianPlaneHelper.getRelevantDecimalReferences(
                                    points = values
                                        .map { it.value }
                                        .toMutableList()
                                        .also { it.add(index = 0, element = 0.0) },
                                    maxValues = 3
                                )
                            ),
                            formatHorizontalReferenceValue = formatLocalDate,
                            formatVerticalReferenceValue = formatValue
                        )
                    ).drawCartesianPlane()
                    drawBars(
                        values = values,
                        cartesianPlaneSpace = cartesianPlaneSpace,
                        animationProgress = animationProgress,
                        color = color
                    )
                }
            }
    )
    LaunchedEffect(Unit) { if (isAnimated) animateBars(animationProgress) }
}

private suspend fun animateBars(animationProgress: Animatable<Float, AnimationVector1D>) {
    animationProgress.animateTo(
        targetValue = 0f,
        animationSpec = tween(durationMillis = 3000)
    )
}

private fun DrawScope.drawBars(
    values: List<BarChartValue>,
    cartesianPlaneSpace: CartesianPlaneSpace,
    animationProgress: Animatable<Float, AnimationVector1D>,
    color: Color
) {
    val barWidth = size.width / ((values.size * 2) + 1)
    val barHeight = cartesianPlaneSpace.height
    val max = values.maxBy { it.value }.value
    var startOfSet = barWidth
    clipRect(top = barHeight * animationProgress.value) {
        values.forEach { bar ->
            val y = (bar.value / max).toFloat() * barHeight
            drawRect(
                color = color.copy(alpha = FunBlocksAlpha.high),
                topLeft = Offset(x = startOfSet, y = barHeight - y),
                size = Size(width = barWidth, height = y)
            )
            startOfSet += barWidth * 2
        }
    }
}

@Composable
private fun rememberAnimationProgress(isAnimated: Boolean) = remember {
    if (isAnimated) Animatable(initialValue = 1f) else Animatable(initialValue = 0f)
}
