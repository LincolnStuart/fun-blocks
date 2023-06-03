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
 * @param description text that describes the button action.
 * @param options [ButtonOptions] to customize button properties.
 * @param onClick callback that executes when click is performed.
 */
@Composable
public fun Button(
    description: String,
    options: ButtonOptions = ButtonOptions(),
    onClick: (() -> Unit)
) = with(options) {
    Clickable(
        description = description,
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
                    description = "Click me!"
                ) {}
                VerticalSpacer(height = FunBlocksSpacing.small)
                Button(
                    description = "Disabled Button",
                    options = ButtonOptions(
                        isEnabled = false
                    )
                ) {}
                VerticalSpacer(height = FunBlocksSpacing.small)
                Button(
                    description = "Button with start icon",
                    options = ButtonOptions(
                        startIcon = TablerIcons.CircleX
                    )
                ) {}
                VerticalSpacer(height = FunBlocksSpacing.small)
                Button(
                    description = "Button with end icon",
                    options = ButtonOptions(
                        endIcon = TablerIcons.CircleX
                    )
                ) {}
                VerticalSpacer(height = FunBlocksSpacing.small)
                Button(
                    description = "Secondary",
                    options = ButtonOptions(
                        mode = ButtonMode.Secondary
                    )
                ) {}
                VerticalSpacer(height = FunBlocksSpacing.small)
                Button(
                    description = "Danger",
                    options = ButtonOptions(
                        mode = ButtonMode.Danger
                    )
                ) {}
            }
        }
    }
}
