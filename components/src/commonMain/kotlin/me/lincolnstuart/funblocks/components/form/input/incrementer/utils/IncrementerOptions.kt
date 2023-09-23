package me.lincolnstuart.funblocks.components.form.input.incrementer.utils

public data class IncrementerOptions(
    val isResetAllowed: Boolean = true,
    val minValue: Int = 0,
    val maxValue: Int = Int.MAX_VALUE
)
