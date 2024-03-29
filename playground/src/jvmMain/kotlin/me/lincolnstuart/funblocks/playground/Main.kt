package me.lincolnstuart.funblocks.playground

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication

public fun main() {
    singleWindowApplication(
        title = "Fun Blocks Playground",
        state = WindowState(
            size = DpSize(width = 500.dp, height = 500.dp)
        )
    ) {
        EntryPoint()
    }
}
