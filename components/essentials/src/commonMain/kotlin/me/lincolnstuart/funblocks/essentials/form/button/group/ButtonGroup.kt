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
import me.lincolnstuart.funblocks.essentials.form.button.group.utils.ButtonOfGroupOptions
import me.lincolnstuart.funblocks.essentials.form.button.utils.ButtonMode
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Group of two button. Based on [ButtonGroup].
 *
 * @param primaryOptions [ButtonOfGroupOptions] to customize main button properties.
 * @param secondaryOptions [ButtonOfGroupOptions] to customize secondary button properties.
 * @param isSensitive if it is a hardcore choice.
 */
@Composable
public fun ButtonGroup(
    primaryOptions: ButtonOfGroupOptions,
    secondaryOptions: ButtonOfGroupOptions,
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
            Button(
                description = secondaryOptions.description,
                options = secondaryOptions.options.copy(mode = ButtonMode.Secondary),
                onClick = secondaryOptions.onClick
            )
        }
        HorizontalSpacer(width = FunBlocksSpacing.xxSmall)
        Column(modifier = Modifier.weight(1f)) {
            Button(
                description = primaryOptions.description,
                options = primaryOptions.options.copy(mode = mode),
                onClick = primaryOptions.onClick
            )
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
                    primaryOptions = ButtonOfGroupOptions(
                        description = "Primary",
                        onClick = { }
                    ),
                    secondaryOptions = ButtonOfGroupOptions(
                        description = "Secondary",
                        onClick = { }
                    )
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                ButtonGroup(
                    primaryOptions = ButtonOfGroupOptions(
                        description = "Danger",
                        onClick = { }
                    ),
                    secondaryOptions = ButtonOfGroupOptions(
                        description = "Secondary",
                        onClick = { }
                    ),
                    isSensitive = true
                )
            }
        }
    }
}
