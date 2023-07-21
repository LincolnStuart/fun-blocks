package me.lincolnstuart.funblocks.foundation.ui.token.color

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

/**
 * Class that create a color to use in Fun Blocks theme. It is an state as well, so
 * your value is correct color based on theme mode.
 *
 * @param light defines what color is the correct in light mode.
 * @param dark defines what color is the correct in dark mode.
 */
public class FunBlocksColor(
    private val light: Color,
    private val dark: Color
) : MutableState<Color> by mutableStateOf(light) {

    /**
     * Updates the state value with the correct color based on theme mode.
     *
     * @param isDarkThemeApplied if dark mode is the choice.
     */
    fun updateValue(isDarkThemeApplied: Boolean) {
        value = if (isDarkThemeApplied) dark else light
    }

    companion object {
        val Transparent = FunBlocksColor(light = Color.Transparent, dark = Color.Transparent)
    }
}
