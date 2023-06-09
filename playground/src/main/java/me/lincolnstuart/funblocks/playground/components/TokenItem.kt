package me.lincolnstuart.funblocks.playground.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontStyle
import me.lincolnstuart.funblocks.core.text.Text
import me.lincolnstuart.funblocks.essentials.list.CustomListItem
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors

@Composable
internal fun TokenItem(
    tokenDescription: String,
    tokenValue: String
) {
    CustomListItem(
        lead = { Text(text = tokenDescription) },
        highlighted = {
            Text(text = tokenValue, style = FontStyle.Italic, color = FunBlocksColors.PrimaryDark)
        }
    )
}
