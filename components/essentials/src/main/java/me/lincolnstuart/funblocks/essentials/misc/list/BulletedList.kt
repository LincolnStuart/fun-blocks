package me.lincolnstuart.funblocks.essentials.misc.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.lincolnstuart.funblocks.core.surface.Surface
import me.lincolnstuart.funblocks.core.text.Text
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Basic bulleted list of topics.
 *
 * @param topics list of [String].
 */
@Composable
public fun BulletedList(topics: List<String>) {
    Column {
        topics.forEach { text ->
            Text(text = "• $text")
        }
    }
}

@Preview
@Composable
private fun BulletedListPreview() {
    FunBlocksTheme {
        Surface {
            Column(modifier = Modifier.padding(FunBlocksSpacing.small)) {
                BulletedList(
                    topics = listOf("Lincoln", "Stuart")
                )
            }
        }
    }
}
