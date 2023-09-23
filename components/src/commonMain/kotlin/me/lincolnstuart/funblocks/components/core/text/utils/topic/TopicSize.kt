package me.lincolnstuart.funblocks.components.core.text.utils.topic

import androidx.compose.ui.unit.TextUnit
import me.lincolnstuart.funblocks.foundation.ui.token.font.FunBlocksFontSize

/**
 * Size options for topic text.
 *
 * @param value represents a correspondent size in SP([TextUnit]).
 */
public enum class TopicSize(val value: TextUnit) {
    Small(value = FunBlocksFontSize.small),
    Large(value = FunBlocksFontSize.large)
}
