package me.lincolnstuart.funblocks.essentials.misc.alert

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import compose.icons.TablerIcons
import compose.icons.tablericons.X
import me.lincolnstuart.funblocks.core.icon.Icon
import me.lincolnstuart.funblocks.core.icon.utils.IconOptions
import me.lincolnstuart.funblocks.core.icon.utils.IconSize
import me.lincolnstuart.funblocks.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.core.surface.Surface
import me.lincolnstuart.funblocks.core.text.Text
import me.lincolnstuart.funblocks.core.text.utils.TextMode
import me.lincolnstuart.funblocks.essentials.misc.alert.utils.AlertCloseOptions
import me.lincolnstuart.funblocks.essentials.misc.alert.utils.AlertMode
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.alpha.FunBlocksAlpha
import me.lincolnstuart.funblocks.foundation.ui.token.content.border.FunBlocksBorderWidth
import me.lincolnstuart.funblocks.foundation.ui.token.content.shape.FunBlocksCornerRadius
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksInset
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Closable status message alert with title and description.
 *
 * @param mode [AlertMode].
 * @param title alert title.
 * @param message optional alert details.
 * @param closeOptions [AlertCloseOptions] that defines if it could close and the icon description.
 */
@Composable
public fun Alert(
    title: String,
    message: String?,
    mode: AlertMode = AlertMode.Info,
    closeOptions: AlertCloseOptions = AlertCloseOptions()
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                border = BorderStroke(
                    width = FunBlocksBorderWidth.tiny,
                    color = mode.color.value()
                ),
                shape = FunBlocksCornerRadius.large
            )
            .clip(FunBlocksCornerRadius.large)
            .background(
                mode.color
                    .value()
                    .copy(alpha = FunBlocksAlpha.low)
            )
            .padding(FunBlocksInset.medium)
    ) {
        Header(
            type = mode,
            title = title,
            closeOptions = closeOptions
        )
        Body(message)
    }
}

@Composable
private fun Body(info: String?) {
    info?.let {
        VerticalSpacer(height = FunBlocksSpacing.xxSmall)
        Text(text = info)
    }
}

@Composable
private fun Header(
    type: AlertMode,
    title: String,
    closeOptions: AlertCloseOptions
) = with(closeOptions) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = type.icon,
            options = IconOptions(
                description = null,
                size = IconSize.Small,
                color = type.color
            ),
            modifier = Modifier.padding(end = FunBlocksSpacing.xxSmall)
        )
        Text(
            text = title,
            modifier = Modifier.weight(1f),
            mode = TextMode.Subtitle(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        onClose?.let { action ->
            Icon(
                imageVector = TablerIcons.X,
                options = IconOptions(
                    description = closeDescription,
                    size = IconSize.Tiny
                ),
                modifier = Modifier
                    .padding(start = FunBlocksSpacing.xxSmall)
                    .clip(CircleShape)
                    .clickable { action() }
            )
        }
    }
}

@Preview
@Composable
private fun AlertPreview() {
    FunBlocksTheme {
        Surface {
            Column(modifier = Modifier.padding(FunBlocksSpacing.small)) {
                Alert(
                    title = "Info",
                    message = LoremIpsum(words = 25).values.first(),
                    closeOptions = AlertCloseOptions(onClose = {})
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                Alert(
                    title = "Info",
                    message = LoremIpsum(words = 25).values.first(),
                    closeOptions = AlertCloseOptions(onClose = {})
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                Alert(
                    title = "Info",
                    message = null
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                Alert(
                    title = "Title greater than one line must show ellipsis",
                    message = null,
                    closeOptions = AlertCloseOptions(onClose = {})
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                Alert(
                    title = "Warning",
                    message = LoremIpsum(words = 25).values.first(),
                    mode = AlertMode.Warning,
                    closeOptions = AlertCloseOptions(onClose = {})
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                Alert(
                    title = "Success",
                    message = LoremIpsum(words = 25).values.first(),
                    mode = AlertMode.Success,
                    closeOptions = AlertCloseOptions(onClose = {})
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                Alert(
                    title = "Error",
                    message = LoremIpsum(words = 25).values.first(),
                    mode = AlertMode.Error,
                    closeOptions = AlertCloseOptions(onClose = {})
                )
            }
        }
    }
}
