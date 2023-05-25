package me.lincolnstuart.funblocks.essentials.form.button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import compose.icons.TablerIcons
import compose.icons.tablericons.CircleX
import me.lincolnstuart.funblocks.core.icon.utils.IconSize
import me.lincolnstuart.funblocks.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.core.surface.Surface
import me.lincolnstuart.funblocks.essentials.form.button.utils.ButtonMode
import me.lincolnstuart.funblocks.essentials.form.button.utils.ButtonOptions
import me.lincolnstuart.funblocks.essentials.helper.clickable.Clickable
import me.lincolnstuart.funblocks.essentials.helper.clickable.utils.ClickableOptions
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Single button that performs a click.
 *
 * @param options [ButtonOptions] to customize button properties.
 */
@Composable
public fun Button(
    options: ButtonOptions
) = with(options) {
    Clickable(
        description = description,
        onClick = onClick,
        options = ClickableOptions(
            backgroundColor = mode.backgroundColor,
            borderColor = FunBlocksColors.Transparent,
            contentColor = mode.contentColor,
            shape = type.shape,
            iconSize = IconSize.Small
        ),
        isEnabled = isEnabled,
        startIcon = startIcon,
        endIcon = endIcon,
        paddingValues = type.paddingValues
    )
}

@Preview
@Composable
private fun ButtonPreview() {
    FunBlocksTheme {
        Surface {
            Column(modifier = Modifier.padding(all = FunBlocksSpacing.small)) {
                Button(
                    options = ButtonOptions(
                        description = "Click me!",
                        onClick = {}
                    )
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                Button(
                    options = ButtonOptions(
                        description = "Disabled Button",
                        onClick = {},
                        isEnabled = false
                    )
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                Button(
                    options = ButtonOptions(
                        description = "Button with start icon",
                        onClick = {},
                        startIcon = TablerIcons.CircleX
                    )
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                Button(
                    options = ButtonOptions(
                        description = "Button with end icon",
                        onClick = {},
                        endIcon = TablerIcons.CircleX
                    )
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                Button(
                    options = ButtonOptions(
                        description = "Secondary",
                        onClick = {},
                        mode = ButtonMode.Secondary
                    )
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                Button(
                    options = ButtonOptions(
                        description = "Danger",
                        onClick = {},
                        mode = ButtonMode.Danger
                    )
                )
            }
        }
    }
}
