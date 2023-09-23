package me.lincolnstuart.funblocks.playground.screens.components.misc.progress

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.components.misc.progress.Stepper
import me.lincolnstuart.funblocks.playground.components.Sample

class StepperScreen : Screen {

    @Composable
    override fun Content() {
        Sample(
            component = { Stepper(stepsCount = 5, selectedStepPosition = 2) }
        ) {}
    }
}
