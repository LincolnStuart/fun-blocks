package me.lincolnstuart.funblocks.essentials.misc.alert

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import me.lincolnstuart.funblocks.essentials.misc.alert.utils.AlertType
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.alpha.FunBlocksAlpha
import me.lincolnstuart.funblocks.foundation.ui.token.content.border.FunBlocksBorderWidth
import me.lincolnstuart.funblocks.foundation.ui.token.content.shape.FunBlocksCornerRadius
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksInset
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Closable status message alert with title and description.
 *
 * @param type [AlertType].
 * @param title alert title.
 * @param info optional alert details.
 * @param closeOptions [AlertCloseOptions] that defines if it could close and the icon description.
 */
@Composable
public fun Alert(
    type: AlertType,
    title: String,
    info: String?,
    closeOptions: AlertCloseOptions = AlertCloseOptions()
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                border = BorderStroke(
                    width = FunBlocksBorderWidth.tiny,
                    color = type.color.value()
                ),
                shape = FunBlocksCornerRadius.large
            )
            .clip(FunBlocksCornerRadius.large)
            .background(
                type.color
                    .value()
                    .copy(alpha = FunBlocksAlpha.low)
            )
            .padding(FunBlocksInset.medium)
    ) {
        Header(
            type = type,
            title = title,
            closeOptions = closeOptions
        )
        Body(info)
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
    type: AlertType,
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
                color = type.darkColor
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
                    size = IconSize.Small
                ),
                modifier = Modifier
                    .padding(start = FunBlocksSpacing.xxSmall)
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
                    type = AlertType.Info,
                    title = "Info",
                    info = LoremIpsum(words = 25).values.first(),
                    closeOptions = AlertCloseOptions(onClose = {})
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                Alert(
                    type = AlertType.Info,
                    title = "Info",
                    info = LoremIpsum(words = 25).values.first(),
                    closeOptions = AlertCloseOptions(onClose = {})
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                Alert(
                    type = AlertType.Info,
                    title = "Info",
                    info = null
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                Alert(
                    type = AlertType.Info,
                    title = "Title greater than one line must show ellipsis",
                    info = null,
                    closeOptions = AlertCloseOptions(onClose = {})
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                Alert(
                    type = AlertType.Warning,
                    title = "Warning",
                    info = LoremIpsum(words = 25).values.first(),
                    closeOptions = AlertCloseOptions(onClose = {})
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                Alert(
                    type = AlertType.Success,
                    title = "Success",
                    info = LoremIpsum(words = 25).values.first(),
                    closeOptions = AlertCloseOptions(onClose = {})
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                Alert(
                    type = AlertType.Error,
                    title = "Error",
                    info = LoremIpsum(words = 25).values.first(),
                    closeOptions = AlertCloseOptions(onClose = {})
                )
            }
        }
    }
}
