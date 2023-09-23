package me.lincolnstuart.funblocks.playground.screens.components.misc

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.components.misc.slider.Slider
import me.lincolnstuart.funblocks.playground.components.Sample
import kotlin.math.roundToInt

class SliderScreen : Screen {

    @Composable
    override fun Content() {
        var percent by remember {
            mutableStateOf(value = 70f)
        }
        Sample(
            component = {
                Slider(
                    percent = percent,
                    description = { "${it.roundToInt()}%" },
                    onPercentChange = { percent = it }
                )
            }
        ) {}
    }
}
