package me.lincolnstuart.funblocks.components.core.appbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import me.lincolnstuart.funblocks.components.core.appbar.utils.AppBarOptions
import me.lincolnstuart.funblocks.components.core.icon.Icon
import me.lincolnstuart.funblocks.components.core.icon.utils.IconOptions
import me.lincolnstuart.funblocks.components.core.icon.utils.IconSize
import me.lincolnstuart.funblocks.components.core.spacer.HorizontalSpacer
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksInset
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

@Composable
public fun AppBar(
    options: AppBarOptions
) = with(options) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(FunBlocksInset.medium)
            .defaultMinSize(minHeight = FunBlocksContentSize.xLarge),
        verticalAlignment = Alignment.CenterVertically
    ) {
        mainAction?.let { action ->
            Icon(
                imageVector = action.icon,
                options = IconOptions(size = IconSize.Small, description = action.description),
                modifier = Modifier.clickable { action.callback() }
            )
            HorizontalSpacer(width = FunBlocksSpacing.xxSmall)
        }
        Column(modifier = Modifier.weight(1f)) {
            mainContent()
        }
        secondaryOptions?.let { options ->
            HorizontalSpacer(width = FunBlocksSpacing.xxSmall)
            options()
        }
    }
}
