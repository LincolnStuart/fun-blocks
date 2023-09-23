package me.lincolnstuart.funblocks.components.misc.cardinfo.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.misc.cardinfo.CardInfo
import me.lincolnstuart.funblocks.components.misc.list.List
import me.lincolnstuart.funblocks.components.misc.list.utils.ListMode

/**
 * Sealed class that presets the [CardInfo] body customization.
 */
public sealed class CardBodyOptions {

    @Composable
    abstract fun Content()

    data class Legend(val text: String) : CardBodyOptions() {
        @Composable
        override fun Content() {
            Text(text = text)
        }
    }

    data class Listing(val topics: List<String>) : CardBodyOptions() {
        @Composable
        override fun Content() {
            List(
                topics = topics,
                mode = ListMode.Enumerated
            )
        }
    }

    data class Characteristic(val characteristics: Map<String, String>) : CardBodyOptions() {
        @Composable
        override fun Content() {
            Column {
                characteristics.keys.forEach { key ->
                    Text(text = "$key: ${characteristics[key]}")
                }
            }
        }
    }

    data class Custom(val content: @Composable () -> Unit) : CardBodyOptions() {
        @Composable
        override fun Content() {
            content()
        }
    }
}
