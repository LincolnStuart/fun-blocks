package me.lincolnstuart.funblocks.playground.components

import androidx.compose.runtime.Composable
import me.lincolnstuart.funblocks.components.core.list.CustomListItem
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.misc.badge.Badge
import me.lincolnstuart.funblocks.components.misc.badge.utils.BadgeMode

@Composable
internal fun TokenItem(
    tokenDescription: String,
    tokenValue: String
) {
    CustomListItem(
        lead = { Text(text = tokenDescription) },
        highlighted = {
            Badge(
                description = tokenValue,
                mode = BadgeMode.Info
            )
        }
    )
}
