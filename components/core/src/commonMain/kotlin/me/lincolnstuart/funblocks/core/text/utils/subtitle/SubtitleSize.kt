package me.lincolnstuart.funblocks.core.text.utils.subtitle

import androidx.compose.ui.unit.TextUnit
import me.lincolnstuart.funblocks.foundation.ui.token.font.FunBlocksFontSize

/**
 * Size options for regular text.
 *
 * @param value represents a correspondent size in SP([TextUnit]).
 */
public enum class SubtitleSize(val value: TextUnit) {
    Medium(value = FunBlocksFontSize.large),
    Large(value = FunBlocksFontSize.xLarge)
}
