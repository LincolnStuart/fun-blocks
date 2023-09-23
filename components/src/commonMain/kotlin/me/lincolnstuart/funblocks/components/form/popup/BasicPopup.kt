package me.lincolnstuart.funblocks.components.form.popup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import me.lincolnstuart.funblocks.components.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.components.core.surface.Surface
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.foundation.ui.token.content.shape.FunBlocksCornerRadius
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksInset
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Basic component of popups. Based on [Dialog].
 *
 * @param title popup title.
 * @param onDismissRequest callback that executes when a click is performed out of the popup.
 * @param properties [DialogProperties] for further customization of this popup's behavior.
 * @param subtitle optional text.
 * @param content the content inside.
 */
@Composable
internal fun BasicPopup(
    title: String,
    onDismissRequest: () -> Unit,
    properties: DialogProperties = DialogProperties(),
    subtitle: String? = null,
    content: @Composable () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = properties
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = FunBlocksCornerRadius.huge)
        ) {
            Column(
                modifier = Modifier
                    .padding(FunBlocksInset.large)
            ) {
                Text(text = title, mode = TextMode.Title())
                subtitle?.let { Text(text = subtitle, mode = TextMode.Subtitle()) }
                VerticalSpacer(height = FunBlocksSpacing.small)
                content()
            }
        }
    }
}
