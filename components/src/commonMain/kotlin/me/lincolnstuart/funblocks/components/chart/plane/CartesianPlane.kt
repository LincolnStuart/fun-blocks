package me.lincolnstuart.funblocks.components.chart.plane

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.drawText
import me.lincolnstuart.funblocks.components.chart.plane.utils.CartesianPlaneOptions

/**
 * Class that draw a cartesian plane based on options.
 *
 * @param drawScope [DrawScope] from canvas.
 * @param textMeasurer [TextMeasurer] responsible for measuring a text in its entirety so that it's
 * ready to be drawn.
 * @param options customized options.
 */
@OptIn(ExperimentalTextApi::class)
internal class CartesianPlane<V, H>(
    private val drawScope: DrawScope,
    private val textMeasurer: TextMeasurer,
    private val options: CartesianPlaneOptions<V, H>
) {

    fun drawCartesianPlane() = with(drawScope) {
        drawRect(
            color = options.lineColor,
            style = Stroke(options.lineWidth.toPx()),
            size = Size(options.space.width, options.space.height)
        )
        val pathEffect = PathEffect.dashPathEffect(
            intervals = floatArrayOf(DEFAULT_LINE_INTERVAL, DEFAULT_LINE_INTERVAL),
            phase = 0f
        )
        bindHorizontalLines(pathEffect)
        if (options.isVerticalLinesVisible) {
            bindVerticalLines(pathEffect)
        }
    }

    private fun DrawScope.bindVerticalLines(pathEffect: PathEffect) = with(options) {
        val xValues = referenceValues.horizontalValues.toMutableList()
        xValues.removeFirst()
        xValues.removeLast()
        drawVerticalLines(
            descriptions = xValues,
            pathEffect = pathEffect
        )
    }

    private fun DrawScope.bindHorizontalLines(pathEffect: PathEffect) = with(options) {
        val yValues = referenceValues.verticalValues.reversed().toMutableList()
        drawText(
            textMeasurer = textMeasurer,
            text = yValues.removeFirst().toString(),
            style = textStyle
        )
        drawText(
            textMeasurer = textMeasurer,
            text = yValues.removeLast().toString(),
            topLeft = Offset(0f, space.height),
            style = textStyle
        )
        drawHorizontalLines(
            descriptions = yValues,
            pathEffect = pathEffect
        )
    }

    private fun DrawScope.drawHorizontalLines(
        descriptions: List<V>,
        pathEffect: PathEffect
    ) = with(options) {
        val count = descriptions.count()
        val horizontalLineSize = space.height / (count + 1)
        repeat(count) { index ->
            val y = horizontalLineSize * (index + 1)
            drawLine(
                color = lineColor,
                start = Offset(0f, y),
                end = Offset(space.width, y),
                strokeWidth = lineWidth.toPx(),
                pathEffect = pathEffect
            )
            drawText(
                textMeasurer = textMeasurer,
                text = formatVerticalReferenceValue(descriptions[index]),
                topLeft = Offset(0f, y),
                style = textStyle
            )
        }
    }

    private fun DrawScope.drawVerticalLines(
        descriptions: List<H>,
        pathEffect: PathEffect
    ) = with(options) {
        val count = descriptions.count()
        val verticalSize = space.width / (count + 1)
        repeat(count) { index ->
            val x = verticalSize * (index + 1)
            val y = space.height
            drawLine(
                color = lineColor,
                start = Offset(x = x, 0f),
                end = Offset(x = x, y = y),
                strokeWidth = lineWidth.toPx(),
                pathEffect = pathEffect
            )
            drawText(
                textMeasurer = textMeasurer,
                text = formatHorizontalReferenceValue(descriptions[index]),
                topLeft = Offset(x, y = y),
                style = textStyle
            )
        }
    }

    private companion object {
        const val DEFAULT_LINE_INTERVAL: Float = 10f
    }
}
