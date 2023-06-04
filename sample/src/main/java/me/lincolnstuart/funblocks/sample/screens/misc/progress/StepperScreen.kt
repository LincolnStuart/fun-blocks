package me.lincolnstuart.funblocks.sample.screens.misc.progress

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.essentials.misc.progress.Stepper
import me.lincolnstuart.funblocks.sample.components.Playground

class StepperScreen : Screen {

    @Composable
    override fun Content() {
        Playground(
            component = {
                Stepper(stepsCount = 5, selectedStepPosition = 2)
            }
        ) {}
    }
}
