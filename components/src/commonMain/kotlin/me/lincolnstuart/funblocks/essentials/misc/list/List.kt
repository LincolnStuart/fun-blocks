package me.lincolnstuart.funblocks.essentials.misc.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.lincolnstuart.funblocks.essentials.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.essentials.core.surface.Surface
import me.lincolnstuart.funblocks.essentials.core.text.Text
import me.lincolnstuart.funblocks.essentials.misc.list.utils.ListMode
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Basic enumerated list of topics.
 *
 * @param topics list of [String].
 * @param mode [ListMode].
 */
@Composable
public fun List(
    topics: List<String>,
    mode: ListMode = ListMode.Bulleted
) {
    Column {
        when (mode) {
            ListMode.Bulleted -> BulletedList(topics = topics)
            ListMode.Enumerated -> EnumeratedList(topics = topics)
        }
    }
}

@Composable
private fun EnumeratedList(topics: List<String>) {
    topics.forEachIndexed { index, text ->
        Text(text = "${index + 1}. $text")
    }
}

@Composable
private fun BulletedList(topics: List<String>) {
    topics.forEach { text ->
        Text(text = "• $text")
    }
}

@Preview
@Composable
private fun ListPreview() {
    FunBlocksTheme {
        Surface {
            Column(modifier = Modifier.padding(FunBlocksSpacing.small)) {
                List(
                    topics = listOf("Lincoln", "Stuart")
                )
                VerticalSpacer(height = FunBlocksSpacing.small)
                List(
                    topics = listOf("Lincoln", "Stuart"),
                    mode = ListMode.Enumerated
                )
            }
        }
    }
}
