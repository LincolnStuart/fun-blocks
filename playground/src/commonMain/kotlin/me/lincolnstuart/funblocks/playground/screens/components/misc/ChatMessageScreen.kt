package me.lincolnstuart.funblocks.playground.screens.components.misc

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
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.components.form.radiobutton.RadioButtonGroup
import me.lincolnstuart.funblocks.components.misc.accordion.Accordion
import me.lincolnstuart.funblocks.components.misc.chat.ChatMessage
import me.lincolnstuart.funblocks.components.misc.chat.utils.ChatMessageOptions
import me.lincolnstuart.funblocks.components.misc.chat.utils.ChatMessageOrientation
import me.lincolnstuart.funblocks.playground.components.Sample

class ChatMessageScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        var options: ChatMessageOptions by remember {
            mutableStateOf(ChatMessageOptions(orientation = ChatMessageOrientation.Sent))
        }
        Sample(
            appBarOptions = AppBarOptions(
                mainContent = { Text(text = "ChatMessage", mode = TextMode.Subtitle()) },
                mainAction = AppBarAction(icon = TablerIcons.ArrowLeft, description = null) {
                    navigator.pop()
                }
            ),
            component = {
                ChatMessage(
                    message = "Chat message",
                    options = options
                )
            }
        ) {
            Accordion(title = "Orientation") {
                RadioButtonGroup(
                    options = listOf(
                        ChatMessageOrientation.Sent,
                        ChatMessageOrientation.Received
                    ),
                    selectedOption = options.orientation,
                    onSelectOption = { options = options.copy(orientation = it) }
                ) {
                    Text(text = it.name)
                }
            }
        }
    }
}
