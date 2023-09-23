package me.lincolnstuart.funblocks.components.core.bottomnavigator

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import me.lincolnstuart.funblocks.components.core.bottomnavigator.utils.BottomNavigatorOptions
import me.lincolnstuart.funblocks.components.core.icon.Icon
import me.lincolnstuart.funblocks.components.core.icon.utils.IconOptions
import me.lincolnstuart.funblocks.components.core.icon.utils.IconSize
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.components.core.text.utils.regular.RegularSize
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksInset
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

@Composable
public fun BottomNavigator(
    options: BottomNavigatorOptions
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(FunBlocksInset.medium)
            .defaultMinSize(minHeight = FunBlocksContentSize.xLarge),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        options.items.forEach { item ->
            Column(
                modifier = Modifier
                    .width(FunBlocksContentSize.huge)
                    .padding(horizontal = FunBlocksSpacing.xxxSmall)
                    .clickable { item.callback() },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = item.icon,
                    options = IconOptions(size = IconSize.Small, description = item.description)
                )
                Text(
                    text = item.label.orEmpty(),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    mode = TextMode.Regular(size = RegularSize.Small)
                )
            }
        }
    }
}
