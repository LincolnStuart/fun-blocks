package me.lincolnstuart.funblocks.chart.pie

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.Dp
import me.lincolnstuart.funblocks.chart.pie.utils.PieChartPiece
import me.lincolnstuart.funblocks.chart.pie.utils.PieChartType
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import java.math.BigDecimal

private const val INITIAL_ANGLE: Float = 270f

/**
 * Pie chart that could be a donut as well.
 *
 * @param data map of description and value of a portion.
 * @param size it is recommended to use [FunBlocksContentSize].
 * @param isAnimated if starts with animation.
 * @param type [PieChartType] pie/donut.
 */
@Composable
fun BasicPieChart(
    data: List<PieChartPiece>,
    size: Dp = FunBlocksContentSize.huge,
    isAnimated: Boolean = false,
    type: PieChartType = PieChartType.Pie
) {
    val style = type.style()
    val totalSum = remember(data) {
        data.fold(BigDecimal.ZERO) { accumulated, current ->
            accumulated.plus(current.value)
        }
    }

    val rotation by rotation(isAnimated)

    Spacer(
        modifier = Modifier
            .size(size)
            .rotate(rotation)
            .drawWithCache {
                var currentAngle = INITIAL_ANGLE
                onDrawBehind {
                    data.forEach { piece ->
                        val pieceArea = piece.getArea(totalSum).toFloat()
                        drawArc(
                            color = piece.color,
                            startAngle = currentAngle,
                            sweepAngle = pieceArea,
                            useCenter = type.isFullArea,
                            style = style
                        )
                        currentAngle += pieceArea
                    }
                }
            }
    )
}

@Composable
private fun rotation(couldAnimate: Boolean): State<Float> {
    var animationPlayed by remember { mutableStateOf(false) }
    if (couldAnimate) {
        LaunchedEffect(Unit) {
            animationPlayed = true
        }
    }
    return animateFloatAsState(
        targetValue = if (animationPlayed) 360f else 0f,
        animationSpec = tween(
            durationMillis = 500,
            easing = LinearOutSlowInEasing
        )
    )
}
