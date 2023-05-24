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
 * Basic enumerated list of topics.
 *
 * @param topics list of [String].
 */
@Composable
public fun EnumeratedList(topics: List<String>) {
    Column {
        topics.forEachIndexed { index, text ->
            Text(text = "${index + 1}. $text")
        }
    }
}

@Preview
@Composable
private fun EnumeratedListPreview() {
    FunBlocksTheme {
        Surface {
            Column(modifier = Modifier.padding(FunBlocksSpacing.small)) {
                EnumeratedList(
                    topics = listOf("Lincoln", "Stuart")
                )
            }
        }
    }
}
