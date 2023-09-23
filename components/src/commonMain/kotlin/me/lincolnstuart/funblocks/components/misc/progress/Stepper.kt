package me.lincolnstuart.funblocks.components.misc.progress

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import me.lincolnstuart.funblocks.components.core.spacer.HorizontalSpacer
import me.lincolnstuart.funblocks.components.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.components.core.surface.Surface
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.shape.FunBlocksCornerRadius
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Basic component that controls number of steps, what is the current one and number of steps conclude.
 *
 * @param stepsCount number of steps.
 * @param selectedStepPosition current step.
 * @param color [FunBlocksColors].
 * @param height it is recommended to use [FunBlocksSpacing].
 * @param onClickStep callback that executes when click is performed and return what step was clicked.
 */
@Composable
public fun Stepper(
    stepsCount: Int,
    selectedStepPosition: Int,
    color: FunBlocksColors = FunBlocksColors.Positive,
    height: Dp = FunBlocksSpacing.xxxSmall,
    onClickStep: (selectedStep: Int) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
    ) {
        repeat(stepsCount) { currentStep ->
            val stepColor = remember {
                if (selectedStepPosition > currentStep) color else FunBlocksColors.SurfaceDark
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clip(FunBlocksCornerRadius.small)
                    .background(stepColor.value())
                    .clickable { onClickStep(currentStep) }
            )
            HorizontalSpacer(width = FunBlocksSpacing.xxxSmall)
        }
    }
}

// @Preview
@Composable
private fun ProgressBarPreview() {
    FunBlocksTheme {
        Surface {
            Column(modifier = Modifier.padding(all = FunBlocksSpacing.xxSmall)) {
                Stepper(stepsCount = 4, selectedStepPosition = 1)
                VerticalSpacer(height = FunBlocksSpacing.small)
                Stepper(stepsCount = 4, selectedStepPosition = 2)
                VerticalSpacer(height = FunBlocksSpacing.small)
                Stepper(stepsCount = 4, selectedStepPosition = 3)
                VerticalSpacer(height = FunBlocksSpacing.small)
                Stepper(stepsCount = 4, selectedStepPosition = 4)
            }
        }
    }
}
