package me.lincolnstuart.funblocks.essentials.form.button.group

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.lincolnstuart.funblocks.core.spacer.HorizontalSpacer
import me.lincolnstuart.funblocks.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.core.surface.Surface
import me.lincolnstuart.funblocks.essentials.form.button.Button
import me.lincolnstuart.funblocks.essentials.form.button.utils.ButtonMode
import me.lincolnstuart.funblocks.essentials.form.button.utils.ButtonOptions
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Group of two button. Based on [ButtonGroup].
 *
 * @param primaryOptions [ButtonOptions] to customize main button properties.
 * @param secondaryOptions [ButtonOptions] to customize secondary button properties.
 * @param isSensitive if it is a hardcore choice.
 */
@Composable
public fun ButtonGroup(
    primaryOptions: ButtonOptions,
    secondaryOptions: ButtonOptions,
    isSensitive: Boolean = false
) {
    val mode = remember(isSensitive) {
        if (isSensitive) ButtonMode.Danger else ButtonMode.Primary
    }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Button(options = secondaryOptions.copy(mode = ButtonMode.Secondary))
        }
        HorizontalSpacer(width = FunBlocksSpacing.xxSmall)
        Column(modifier = Modifier.weight(1f)) {
            Button(options = primaryOptions.copy(mode = mode))
        }
    }
}

@Preview
@Composable
private fun ButtonGroupPreview() {
    FunBlocksTheme {
        Surface {
            Column(Modifier.padding(FunBlocksSpacing.small)) {
                ButtonGroup(
                    primaryOptions = ButtonOptions(
                        description = "Primary",
                        onClick = { }
                    ),
                    secondaryOptions = ButtonOptions(
                        description = "Secondary",
                        onClick = { }
                    )
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                ButtonGroup(
                    primaryOptions = ButtonOptions(
                        description = "Danger",
                        onClick = { }
                    ),
                    secondaryOptions = ButtonOptions(
                        description = "Secondary",
                        onClick = { }
                    ),
                    isSensitive = true
                )
            }
        }
    }
}
