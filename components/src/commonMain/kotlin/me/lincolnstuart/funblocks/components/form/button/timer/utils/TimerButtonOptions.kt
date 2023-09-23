package me.lincolnstuart.funblocks.components.form.button.timer.utils

import me.lincolnstuart.funblocks.components.form.button.utils.ButtonMode
import me.lincolnstuart.funblocks.components.form.button.utils.ButtonType

/**
 * Data class that customize button options.
 *
 * @param mode [ButtonMode] style.
 * @param type [ButtonType].
 * @param blockingTimeInSeconds time the button is inoperative.
 */
public data class TimerButtonOptions(
    val mode: ButtonMode = ButtonMode.Primary,
    val type: ButtonType = ButtonType.Regular,
    val blockingTimeInSeconds: Int = 30
)
