package me.lincolnstuart.funblocks.sample.screens.form

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.essentials.form.switchbutton.SwitchButton
import me.lincolnstuart.funblocks.sample.components.Playground

class SwitchButtonScreen : Screen {

    @Composable
    override fun Content() {
        var isOn by remember {
            mutableStateOf(false)
        }
        Playground(component = {
            SwitchButton(isOn = isOn, onClick = { isOn = it })
        }) {}
    }
}
