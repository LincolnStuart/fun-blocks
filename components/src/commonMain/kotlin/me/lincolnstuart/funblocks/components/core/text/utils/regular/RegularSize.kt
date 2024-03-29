package me.lincolnstuart.funblocks.components.core.text.utils.regular

import androidx.compose.ui.unit.TextUnit
import me.lincolnstuart.funblocks.foundation.ui.token.font.FunBlocksFontSize

/**
 * Size options for regular text.
 *
 * @param value represents a correspondent size in SP([TextUnit]).
 */
public enum class RegularSize(val value: TextUnit) {
    Small(value = FunBlocksFontSize.small),
    Medium(value = FunBlocksFontSize.medium),
    Large(value = FunBlocksFontSize.large)
}
