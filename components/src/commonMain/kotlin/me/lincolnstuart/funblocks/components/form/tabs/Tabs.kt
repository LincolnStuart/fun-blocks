package me.lincolnstuart.funblocks.components.form.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import me.lincolnstuart.funblocks.components.core.icon.Icon
import me.lincolnstuart.funblocks.components.core.icon.utils.IconOptions
import me.lincolnstuart.funblocks.components.core.icon.utils.IconSize
import me.lincolnstuart.funblocks.components.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.components.core.text.utils.regular.RegularSize
import me.lincolnstuart.funblocks.components.form.tabs.utils.TabOption
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

@Composable
public fun Tabs(
    options: List<TabOption>
) {
    var checkedOption by remember(options) { mutableStateOf(0) }
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = FunBlocksContentSize.xLarge)
                .background(color = FunBlocksColors.Surface.value()),
            verticalAlignment = Alignment.CenterVertically
        ) {
            options.forEachIndexed { index, option ->
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .width(FunBlocksContentSize.huge)
                        .clickable { checkedOption = index }
                        .padding(top = FunBlocksSpacing.xxSmall),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = option.icon,
                        options = IconOptions(
                            size = IconSize.Small,
                            description = option.description
                        )
                    )
                    Text(
                        text = option.label.orEmpty(),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        mode = TextMode.Regular(size = RegularSize.Small)
                    )
                    val markerColor = remember(checkedOption) {
                        if (checkedOption == index) {
                            FunBlocksColors.Primary
                        } else {
                            FunBlocksColors.Transparent
                        }
                    }
                    VerticalSpacer(height = FunBlocksSpacing.xxSmall)
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(FunBlocksSpacing.xxxSmall)
                            .background(markerColor.value())
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .verticalScroll(state = scrollState)
                .fillMaxSize()
                .padding(all = FunBlocksSpacing.small)
        ) {
            options[checkedOption].content()
        }
    }
}
