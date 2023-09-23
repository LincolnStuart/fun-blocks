package me.lincolnstuart.funblocks.playground.screens.components.form

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.components.form.switchbutton.SwitchButton
import me.lincolnstuart.funblocks.playground.components.Sample

class SwitchButtonScreen : Screen {

    @Composable
    override fun Content() {
        var isOn by remember {
            mutableStateOf(false)
        }
        Sample(
            component = { SwitchButton(isOn = isOn, onClick = { isOn = it }) }
        ) {}
    }
}
