package me.lincolnstuart.funblocks.components.misc.accordion

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import compose.icons.TablerIcons
import compose.icons.tablericons.Minus
import compose.icons.tablericons.Plus
import me.lincolnstuart.funblocks.components.core.icon.Icon
import me.lincolnstuart.funblocks.components.core.icon.utils.IconOptions
import me.lincolnstuart.funblocks.components.core.icon.utils.IconSize
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.components.misc.divider.HorizontalDivider
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

@Composable
public fun Accordion(
    title: String,
    content: @Composable () -> Unit
) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    val icon = remember(isExpanded) {
        if (isExpanded)TablerIcons.Minus else TablerIcons.Plus
    }
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(FunBlocksColors.Surface.value())
                .clickable { isExpanded = isExpanded.not() }
                .padding(FunBlocksSpacing.small),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = title, mode = TextMode.Subtitle(), modifier = Modifier.weight(1f))
            Icon(
                imageVector = icon,
                options = IconOptions(description = null, size = IconSize.Tiny)
            )
        }
        AnimatedVisibility(isExpanded) {
            Column(
                modifier = Modifier
                    .background(FunBlocksColors.SurfaceMedium.value())
                    .padding(horizontal = FunBlocksSpacing.small)
            ) {
                content()
            }
        }
        HorizontalDivider()
    }
}
