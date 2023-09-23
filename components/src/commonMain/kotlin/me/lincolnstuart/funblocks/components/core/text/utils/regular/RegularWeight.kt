package me.lincolnstuart.funblocks.components.core.text.utils.regular

import androidx.compose.ui.text.font.FontWeight
import me.lincolnstuart.funblocks.foundation.ui.token.font.FunBlocksFontWeight

/**
 * Weight options for regular text.
 *
 * @param value represents a correspondent weight([FontWeight]).
 */
public enum class RegularWeight(val value: FontWeight) {
    Light(FunBlocksFontWeight.light),
    Regular(FunBlocksFontWeight.regular),
    SemiBold(FunBlocksFontWeight.semiBold),
    Bold(FunBlocksFontWeight.bold)
}
