package me.lincolnstuart.funblocks.essentials.form.popup

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.DialogProperties
import me.lincolnstuart.funblocks.essentials.core.surface.Surface
import me.lincolnstuart.funblocks.essentials.core.text.Text
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme

/**
 * Message popup with no choice, just a text. Based on [BasicPopup].
 *
 * @param title popup title.
 * @param onDismissRequest callback that executes when a click is performed out of the popup.
 * @param properties [DialogProperties] for further customization of this popup's behavior.
 * @param subtitle optional text.
 */
@Composable
public fun InfoPopup(
    title: String,
    message: String,
    onDismissRequest: () -> Unit,
    properties: DialogProperties = DialogProperties(),
    subtitle: String? = null
) {
    BasicPopup(
        title = title,
        onDismissRequest = onDismissRequest,
        properties = properties,
        subtitle = subtitle
    ) {
        Text(text = message)
    }
}

// @Preview
@Composable
private fun InfoPopupPreview() {
    FunBlocksTheme {
        Surface {
            InfoPopup(
                title = "Title",
                message = "Message",
                onDismissRequest = { }
            )
        }
    }
}
