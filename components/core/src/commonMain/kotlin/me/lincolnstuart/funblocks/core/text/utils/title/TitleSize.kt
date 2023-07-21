package me.lincolnstuart.funblocks.core.text.utils.title

import androidx.compose.ui.unit.TextUnit
import me.lincolnstuart.funblocks.foundation.ui.token.font.FunBlocksFontSize

/**
 * Size options for regular text.
 *
 * @param value represents a correspondent size in SP([TextUnit]).
 */
public enum class TitleSize(val value: TextUnit) {
    H1(value = FunBlocksFontSize.xxxLarge),
    H2(value = FunBlocksFontSize.xxLarge),
    H3(value = FunBlocksFontSize.xLarge)
}
