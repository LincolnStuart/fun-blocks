package me.lincolnstuart.funblocks.components.form.popup

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.DialogProperties
import me.lincolnstuart.funblocks.components.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.components.core.surface.Surface
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.form.button.group.ButtonGroup
import me.lincolnstuart.funblocks.components.form.button.group.utils.ButtonOfGroupOptions
import me.lincolnstuart.funblocks.components.form.button.utils.ButtonType
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Popup with a choice to execute some task. Based on [BasicPopup].
 *
 * @param title popup title.
 * @param onDismissRequest callback that executes when a click is performed out of the popup.
 * @param primaryActionOptions primary [ButtonOfGroupOptions].
 * @param secondaryActionOptions secondary [ButtonOfGroupOptions].
 * @param properties [DialogProperties] for further customization of this popup's behavior.
 * @param subtitle optional text.
 * @param isSensitive if it is a hardcore choice.
 * @param content the content inside.
 */
@Composable
public fun ActionPopup(
    title: String,
    onDismissRequest: () -> Unit,
    primaryActionOptions: ButtonOfGroupOptions,
    secondaryActionOptions: ButtonOfGroupOptions,
    properties: DialogProperties = DialogProperties(),
    isSensitive: Boolean = false,
    subtitle: String? = null,
    content: @Composable () -> Unit
) {
    BasicPopup(
        title = title,
        onDismissRequest = onDismissRequest,
        properties = properties,
        subtitle = subtitle
    ) {
        content()
        VerticalSpacer(height = FunBlocksSpacing.medium)
        ButtonGroup(
            primaryOptions = primaryActionOptions.copy(
                options = primaryActionOptions.options.copy(type = ButtonType.Small)
            ),
            secondaryOptions = secondaryActionOptions.copy(
                options = secondaryActionOptions.options.copy(type = ButtonType.Small)
            ),
            isSensitive = isSensitive
        )
    }
}

// @Preview
@Composable
private fun ActionPopupPreview() {
    FunBlocksTheme {
        Surface {
            ActionPopup(
                title = "Title",
                onDismissRequest = { },
                primaryActionOptions = ButtonOfGroupOptions(
                    description = "Primary",
                    onClick = { }
                ),
                secondaryActionOptions = ButtonOfGroupOptions(
                    description = "Secondary",
                    onClick = { }
                )
            ) {
                Text(text = "Content")
            }
        }
    }
}
