package me.lincolnstuart.funblocks.components.misc.slider

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import me.lincolnstuart.funblocks.components.core.surface.Surface
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.misc.progress.ProgressBar
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing
import kotlin.math.roundToInt

private const val FULL_PERCENTAGE = 100f

/**
 * Basic slider component that controls percent by dragging component.
 *
 * @param percent actual percent.
 * @param description formatted choice value.
 * @param onPercentChange the callback that is triggered when the slider is working.
 */
@Composable
public fun Slider(
    percent: Float,
    description: (percent: Float) -> String,
    onPercentChange: (percent: Float) -> Unit
) {
    Column {
        var size by remember { mutableStateOf(IntSize.Zero) }
        BoxWithConstraints(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            val width = constraints.maxWidth.toFloat()
            val edge = width / 2
            val limits = (edge * -1)..edge
            var offsetX by remember(percent, width) {
                mutableStateOf(percent * width / FULL_PERCENTAGE - edge)
            }
            ProgressBar(
                percent = percent,
                color = FunBlocksColors.Primary,
                height = FunBlocksSpacing.xxSmall,
                paddingValues = PaddingValues(vertical = FunBlocksSpacing.small),
                isAnimated = false
            )
            Box(
                Modifier
                    .padding(vertical = FunBlocksSpacing.small)
                    .onGloballyPositioned { size = it.size }
                    .offset { IntOffset(x = offsetX.roundToInt(), y = 0) }
                    .size(FunBlocksContentSize.small)
                    .clip(shape = CircleShape)
                    .background(color = FunBlocksColors.Primary.value())
                    .pointerInput(Unit) {
                        detectDragGestures { _, dragAmount ->
                            val newPosition = offsetX + dragAmount.x
                            offsetX = when {
                                newPosition < limits.start -> limits.start
                                newPosition > limits.endInclusive -> limits.endInclusive
                                else -> newPosition
                            }
                            val newPercent = (offsetX + edge) * FULL_PERCENTAGE / width
                            onPercentChange(newPercent)
                        }
                    }
            )
        }
        Text(text = description(percent))
    }
}

// @Preview
@Composable
private fun SliderPreview() {
    FunBlocksTheme {
        Surface {
            Column(
                modifier = Modifier.padding(all = FunBlocksSpacing.small),
                verticalArrangement = Arrangement.Absolute.spacedBy(FunBlocksSpacing.xxSmall)
            ) {
                Slider(percent = 0f, description = { "${it.roundToInt()}%" }, onPercentChange = {})
                Slider(percent = 50f, description = { "${it.roundToInt()}%" }, onPercentChange = {})
                Slider(percent = 75f, description = { "${it.roundToInt()}%" }, onPercentChange = {})
                Slider(percent = 100f, description = { "${it.roundToInt()}%" }, onPercentChange = {})
            }
        }
    }
}
