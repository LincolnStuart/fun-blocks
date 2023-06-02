package me.lincolnstuart.funblocks.essentials.form.select

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import compose.icons.TablerIcons
import compose.icons.tablericons.ChevronDown
import me.lincolnstuart.funblocks.core.icon.Icon
import me.lincolnstuart.funblocks.core.icon.utils.IconOptions
import me.lincolnstuart.funblocks.core.icon.utils.IconSize
import me.lincolnstuart.funblocks.core.text.Text
import me.lincolnstuart.funblocks.core.text.utils.TextMode
import me.lincolnstuart.funblocks.core.text.utils.topic.TopicSize
import me.lincolnstuart.funblocks.essentials.form.select.utils.SelectOptions
import me.lincolnstuart.funblocks.essentials.form.utils.BasicInputSkeleton
import me.lincolnstuart.funblocks.essentials.helper.Counter
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksInset
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Generic select responsible to draw an basic select component.
 *
 * @param options customized options.
 * @param paddingValues it is recommended to use [FunBlocksSpacing] or [FunBlocksInset].
 * @param onClick callback that executes when click is performed.
 * @param contentOptions options that will be showed when the click is performed.
 */
@Composable
internal fun BasicSelect(
    options: SelectOptions,
    paddingValues: PaddingValues,
    onClick: () -> Unit,
    contentOptions: @Composable () -> Unit
) = with(options) {
    BasicInputSkeleton(
        content = {
            Column {
                SelectInput(
                    label = label,
                    value = selectedItem,
                    placeholder = placeholder,
                    expandOptionDescription = expandOptionDescription,
                    counter = counter
                )
            }
        },
        error = error,
        modifier = Modifier
            .padding(paddingValues)
            .clickable { onClick() }
    )
    contentOptions()
}

@Composable
private fun SelectInput(
    label: String?,
    value: String,
    placeholder: String?,
    expandOptionDescription: String?,
    counter: Int?
) {
    Row {
        Column(modifier = Modifier.weight(1f)) {
            label?.let {
                Text(
                    text = label,
                    mode = TextMode.Topic(size = TopicSize.Small)
                )
            }
            Box {
                if (value.isEmpty()) {
                    Text(text = placeholder.orEmpty())
                }
                OneLineText(text = value)
            }
        }
        if (counter != null && counter > 0) {
            Counter(
                formattedNumber = counter.toString(),
                modifier = Modifier
                    .padding(horizontal = FunBlocksSpacing.xxxSmall)
                    .align(Alignment.CenterVertically)
            )
        }
        SelectOption(
            icon = TablerIcons.ChevronDown,
            description = expandOptionDescription
        )
    }
}

@Composable
private fun RowScope.SelectOption(
    icon: ImageVector,
    description: String?
) {
    Icon(
        imageVector = icon,
        options = IconOptions(
            description = description,
            size = IconSize.Tiny
        ),
        modifier = Modifier
            .align(Alignment.CenterVertically)
    )
}

@Composable
private fun OneLineText(text: String) {
    Text(
        text = text,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}
