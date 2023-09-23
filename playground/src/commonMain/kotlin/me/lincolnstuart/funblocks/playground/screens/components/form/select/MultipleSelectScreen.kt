package me.lincolnstuart.funblocks.playground.screens.components.form.select

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import compose.icons.TablerIcons
import compose.icons.tablericons.ArrowLeft
import me.lincolnstuart.funblocks.components.core.appbar.utils.AppBarAction
import me.lincolnstuart.funblocks.components.core.appbar.utils.AppBarOptions
import me.lincolnstuart.funblocks.components.core.helper.SelectableItem
import me.lincolnstuart.funblocks.components.core.screenplan.ScreenPlan
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.components.form.select.MultipleSelect
import me.lincolnstuart.funblocks.components.form.switchbutton.SwitchButtonOption
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksInset
import me.lincolnstuart.funblocks.playground.components.ComponentCentralizer

class MultipleSelectScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
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
        ScreenPlan(
            appBarOptions = AppBarOptions(
                mainContent = { Text(text = "MultipleSelect", mode = TextMode.Subtitle()) },
                mainAction = AppBarAction(icon = TablerIcons.ArrowLeft, description = null) {
                    navigator.pop()
                }
            ),
            mainContent = {
                ComponentCentralizer {
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
