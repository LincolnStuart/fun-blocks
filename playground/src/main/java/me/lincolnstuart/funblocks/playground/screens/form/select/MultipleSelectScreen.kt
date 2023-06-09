package me.lincolnstuart.funblocks.playground.screens.form.select

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.essentials.form.select.MultipleSelect
import me.lincolnstuart.funblocks.essentials.form.switchbutton.SwitchButtonOption
import me.lincolnstuart.funblocks.essentials.helper.SelectableItem
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksInset
import me.lincolnstuart.funblocks.playground.components.Sample

class MultipleSelectScreen : Screen {

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
        val selectedValues = remember {
            mutableStateOf<List<String>>(emptyList())
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
                MultipleSelect(
                    selectedValues = selectedValues.value,
                    onSelectValues = {
                        selectedValues.value = it
                    },
                    options = options,
                    mapToPresentation = {
                        SelectableItem(description = it)
                    },
                    paddingValues = FunBlocksInset.medium,
                    label = "Select some languages",
                    placeholder = "Enter your favourite languages",
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
