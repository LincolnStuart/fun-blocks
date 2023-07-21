package me.lincolnstuart.funblocks.essentials.misc.progress

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import me.lincolnstuart.funblocks.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.core.surface.Surface
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.shape.FunBlocksCornerRadius
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksInset
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

private const val FULL_PERCENTAGE: Float = 100f

/**
 * Basic progress bar by percent value.
 *
 * @param percent amount concluded.
 * @param color [FunBlocksColors].
 * @param height it is recommended to use [FunBlocksSpacing].
 * @param paddingValues it is recommended to use [FunBlocksSpacing] or [FunBlocksInset].
 */
@Composable
public fun ProgressBar(
    percent: Float,
    color: FunBlocksColors = FunBlocksColors.Positive,
    height: Dp = FunBlocksSpacing.xxxSmall,
    paddingValues: PaddingValues = PaddingValues(),
    isAnimated: Boolean = true
) {
    val percentageProgress = remember(percent) {
        percent / FULL_PERCENTAGE
    }
    val progress by animateFloatAsState(
        targetValue = percentageProgress,
        tween(
            durationMillis = if (isAnimated)500 else 0,
            delayMillis = if (isAnimated)100 else 0,
            easing = LinearOutSlowInEasing
        )
    )
    Row(
        Modifier
            .padding(paddingValues)
            .fillMaxWidth()
            .height(height)
            .clip(shape = FunBlocksCornerRadius.full)
            .background(FunBlocksColors.SurfaceDark.value())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(progress)
                .fillMaxHeight()
                .clip(FunBlocksCornerRadius.small)
                .background(color.value())
        )
    }
}

@Preview
@Composable
private fun ProgressBarPreview() {
    FunBlocksTheme {
        Surface {
            Column(modifier = Modifier.padding(all = FunBlocksSpacing.xxSmall)) {
                ProgressBar(percent = 100f)
                VerticalSpacer(height = FunBlocksSpacing.xxxSmall)
                ProgressBar(percent = 50f)
                VerticalSpacer(height = FunBlocksSpacing.xxxSmall)
                ProgressBar(percent = 25f)
                VerticalSpacer(height = FunBlocksSpacing.xxxSmall)
                ProgressBar(percent = 2f)
            }
        }
    }
}
