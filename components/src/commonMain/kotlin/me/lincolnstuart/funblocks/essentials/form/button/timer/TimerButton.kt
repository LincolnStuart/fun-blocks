package me.lincolnstuart.funblocks.essentials.form.button.timer

import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import me.lincolnstuart.funblocks.essentials.core.helper.clickable.Clickable
import me.lincolnstuart.funblocks.essentials.core.helper.clickable.utils.ClickableOptions
import me.lincolnstuart.funblocks.essentials.core.icon.utils.IconSize
import me.lincolnstuart.funblocks.essentials.core.surface.Surface
import me.lincolnstuart.funblocks.essentials.form.button.timer.utils.TimerButtonOptions
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing
import kotlin.time.Duration.Companion.seconds

/**
 * Timer button that performs a click and controls enabling status.
 *
 * @param description text that describes the button action.
 * @param options [TimerButtonOptions] to customize button properties.
 * @param onClick callback that executes when click is performed.
 */
@Composable
public fun TimerButton(
    description: String,
    options: TimerButtonOptions = TimerButtonOptions(),
    onClick: (() -> Unit)
) = with(options) {
    var remainingSeconds by remember { mutableStateOf(blockingTimeInSeconds) }
    val isEnabled = remember(remainingSeconds) {
        remainingSeconds <= 0
    }
    val label = remember(remainingSeconds) {
        if (isEnabled) {
            description
        } else {
            "$description ($remainingSeconds)"
        }
    }
    LaunchedEffect(isEnabled) {
        while (remainingSeconds > 0) {
            delay(1.seconds)
            remainingSeconds--
        }
    }
    Clickable(
        description = label,
        onClick = onClick,
        options = ClickableOptions(
            backgroundColor = mode.backgroundColor,
            borderColor = FunBlocksColors.Transparent,
            contentColor = mode.contentColor,
            shape = type.shape,
            iconSize = IconSize.Small,
            height = type.height
        ),
        isEnabled = isEnabled,
        paddingValues = type.paddingValues
    )
}

@Preview
@Composable
private fun TimerButtonPreview() {
    FunBlocksTheme {
        Surface {
            Column(
                modifier = Modifier.padding(all = FunBlocksSpacing.small),
                verticalArrangement = spacedBy(FunBlocksSpacing.xxSmall)
            ) {
                TimerButton(description = "Timer Button") {}
            }
        }
    }
}
