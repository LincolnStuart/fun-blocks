package me.lincolnstuart.funblocks.playground.screens.components.form

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.essentials.form.radiobutton.RadioButton
import me.lincolnstuart.funblocks.playground.components.Sample

class RadioButtonScreen : Screen {

    @Composable
    override fun Content() {
        var isChecked by remember {
            mutableStateOf(false)
        }
        Sample(
            component = { RadioButton(isSelected = isChecked, onClick = { isChecked = !isChecked }) }
        ) {}
    }
}
