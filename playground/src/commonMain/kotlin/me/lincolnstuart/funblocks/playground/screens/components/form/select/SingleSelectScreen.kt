package me.lincolnstuart.funblocks.playground.screens.components.form.select

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.essentials.core.helper.SelectableItem
import me.lincolnstuart.funblocks.essentials.form.select.SingleSelect
import me.lincolnstuart.funblocks.essentials.form.switchbutton.SwitchButtonOption
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksInset
import me.lincolnstuart.funblocks.playground.components.Sample

class SingleSelectScreen : Screen {

    @Composable
    override fun Content() {
        var error: String? by remember {
            mutableStateOf(null)
        }
        var enabled by remember {
            mutableStateOf(true)
        }
        var readOnly by remember {
            mutableStateOf(false)
        }
        val selectedValue = remember {
            mutableStateOf<String?>(null)
        }
        val options = remember {
            listOf(
                "Kotlin",
                "Java",
                "Swift",
                "Dart"
            )
        }
        Sample(
            component = {
                SingleSelect(
                    selectedValue = selectedValue.value,
                    onSelectValue = {
                        selectedValue.value = it
                    },
                    options = options,
                    mapToPresentation = {
                        SelectableItem(description = it)
                    },
                    paddingValues = FunBlocksInset.medium,
                    label = "Select a language",
                    placeholder = "Enter your favourite language",
                    enabled = enabled,
                    readOnly = readOnly,
                    error = error
                )
            }
        ) {
            SwitchButtonOption(
                description = "Enabled",
                isOn = enabled,
                onClick = { enabled = !enabled }
            )
            SwitchButtonOption(
                description = "Read only",
                isOn = readOnly,
                onClick = { readOnly = !readOnly }
            )
            SwitchButtonOption(
                description = "Error",
                isOn = error != null,
                onClick = { error = if (error == null) "some error" else null }
            )
        }
    }
}
