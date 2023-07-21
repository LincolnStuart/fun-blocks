package me.lincolnstuart.funblocks.chart.line

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import kotlinx.datetime.LocalDate
import me.lincolnstuart.funblocks.chart.line.utils.LineChartPath
import me.lincolnstuart.funblocks.chart.line.utils.LineChartPoint
import me.lincolnstuart.funblocks.chart.plane.CartesianPlane
import me.lincolnstuart.funblocks.chart.plane.utils.CartesianPlaneHelper
import me.lincolnstuart.funblocks.chart.plane.utils.CartesianPlaneOptions
import me.lincolnstuart.funblocks.chart.plane.utils.CartesianPlaneReferenceValues
import me.lincolnstuart.funblocks.chart.plane.utils.CartesianPlaneSpace
import me.lincolnstuart.funblocks.core.surface.Surface
import me.lincolnstuart.funblocks.core.text.utils.TextMode
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.theme.LocalTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.border.FunBlocksBorderWidth
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing
import me.lincolnstuart.funblocks.foundation.ui.token.font.FunBlocksFontSize
import java.math.BigDecimal

/**
 * Line chart that draws paths in a cartesian plane based on a time line.
 *
 * @param paths list of [LineChartPath] to draw in a cartesian plane.
 * @param height it is recommended to use [FunBlocksContentSize].
 * @param isAnimated if starts with animation.
 * @param formatBigDecimal to string from [BigDecimal].
 * @param formatLocalDate to string from [LocalDate].
 */
@OptIn(ExperimentalTextApi::class)
@Composable
public fun BasicLineChart(
    paths: List<LineChartPath>,
    height: Dp = FunBlocksContentSize.huge,
    isAnimated: Boolean = false,
    formatBigDecimal: (BigDecimal) -> String = { it.toString() },
    formatLocalDate: (LocalDate) -> String = { it.toString() }
) {
    val textMeasurer = rememberTextMeasurer()
    val animationProgress = rememberAnimationProgress(isAnimated)
    val allPoints = rememberAllPoints(paths)
    val lineColor = FunBlocksColors.Border.value()
    val textColor = FunBlocksColors.Neutral.value()
    val mode = remember { TextMode.Regular() }
    val theme = LocalTheme.current
    Spacer(
        modifier = Modifier
            .height(height)
            .fillMaxWidth()
            .drawWithCache {
                val cartesianPlaneSpace = CartesianPlaneSpace(
                    height = size.height - FunBlocksFontSize.xLarge.toPx(),
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
                            isVerticalLinesVisible = true,
                            textStyle = TextStyle(
                                fontFamily = theme.fontFamily,
                                fontWeight = mode.fontWeight,
                                fontSize = mode.fontSize,
                                color = textColor
                            ),
                            referenceValues = CartesianPlaneReferenceValues(
                                horizontalValues = CartesianPlaneHelper.getRelevantDateReferences(
                                    points = allPoints.map { it.date },
                                    maxValues = 4
                                ),
                                verticalValues = CartesianPlaneHelper.getRelevantDecimalReferences(
                                    points = allPoints.map { it.value },
                                    maxValues = 3
                                )
                            ),
                            formatHorizontalReferenceValue = formatLocalDate,
                            formatVerticalReferenceValue = formatBigDecimal
                        )
                    ).drawCartesianPlane()
                    drawPaths(
                        animationProgress = animationProgress,
                        paths = paths,
                        allPoints = allPoints,
                        cartesianPlaneSpace = cartesianPlaneSpace
                    )
                }
            }
    )
    LaunchedEffect(Unit) {
        animationProgress.animateTo(targetValue = 1f, animationSpec = tween(durationMillis = 3000))
    }
}

@Composable
private fun rememberAllPoints(paths: List<LineChartPath>) =
    remember(paths) {
        paths.flatMap { it.points }.sortedBy { it.date }
    }

@Composable
private fun rememberAnimationProgress(isAnimated: Boolean) = remember {
    if (isAnimated) Animatable(0f) else Animatable(1f)
}

private fun DrawScope.drawPaths(
    animationProgress: Animatable<Float, AnimationVector1D>,
    paths: List<LineChartPath>,
    allPoints: List<LineChartPoint>,
    cartesianPlaneSpace: CartesianPlaneSpace
) {
    clipRect(right = size.width * animationProgress.value) {
        paths.forEachIndexed { index, path ->
            drawPath(
                points = path.points.sortedBy { it.date },
                allPoints = allPoints,
                color = path.color,
                height = cartesianPlaneSpace.height
            )
        }
    }
}

private fun DrawScope.drawPath(
    points: List<LineChartPoint>,
    color: Color,
    height: Float,
    allPoints: List<LineChartPoint>
) {
    drawPath(
        path = generatePath(
            points = points,
            height = height,
            allPoints = allPoints
        ),
        color = color,
        style = Stroke(FunBlocksBorderWidth.large.toPx())
    )
}

private fun DrawScope.generatePath(
    points: List<LineChartPoint>,
    height: Float,
    allPoints: List<LineChartPoint>
): Path {
    val path = Path()
    val widthBetweenItems = getWidthBetween(points)
    val heightBetweenItems = getHeightBetweenItems(allPoints, height)
    var xSegmentStart = 0f
    var ySegmentStart = height
    points.forEachIndexed { index, point ->
        val y = height - point.value.toFloat() * heightBetweenItems
        if (index == 0) {
            path.moveTo(x = 0f, y = y)
        } else {
            val x = index * widthBetweenItems
            val xControlPoint = (x + xSegmentStart) / 2f
            path.cubicTo(
                x1 = xControlPoint,
                y1 = ySegmentStart,
                x2 = xControlPoint,
                y2 = y,
                x3 = x,
                y3 = y
            )
            xSegmentStart = x
            ySegmentStart = y
        }
    }
    return path
}

private fun getHeightBetweenItems(
    allPoints: List<LineChartPoint>,
    height: Float
): Float {
    val max = allPoints.maxBy { it.value }
    val min = allPoints.minBy { it.value }
    val range = max.value - min.value
    return height / range.toFloat()
}

private fun DrawScope.getWidthBetween(points: List<LineChartPoint>): Float {
    val numberEntries = points.size - 1
    return size.width / numberEntries
}

@Preview
@Composable
private fun BasicLineChartPreview() {
    FunBlocksTheme {
        Surface {
            Box(modifier = Modifier.padding(FunBlocksSpacing.medium)) {
                BasicLineChart(
                    paths = listOf(
                        LineChartPath(
                            description = "Line 1",
                            points = listOf(
                                LineChartPoint(
                                    value = BigDecimal("1"),
                                    date = LocalDate(year = 1990, monthNumber = 10, dayOfMonth = 12)
                                ),
                                LineChartPoint(
                                    value = BigDecimal("10"),
                                    date = LocalDate(year = 1944, monthNumber = 11, dayOfMonth = 17)
                                ),
                                LineChartPoint(
                                    value = BigDecimal("7"),
                                    date = LocalDate(year = 1944, monthNumber = 11, dayOfMonth = 17)
                                )
                            ),
                            color = FunBlocksColors.Data1.value()
                        )
                    )
                )
            }
        }
    }
}
