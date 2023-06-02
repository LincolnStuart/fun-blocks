package me.lincolnstuart.funblocks.sample.screens.misc

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.core.text.Text
import me.lincolnstuart.funblocks.essentials.form.radiobutton.RadioButtonGroup
import me.lincolnstuart.funblocks.essentials.misc.accordion.Accordion
import me.lincolnstuart.funblocks.essentials.misc.chat.ChatMessage
import me.lincolnstuart.funblocks.essentials.misc.chat.utils.ChatMessageOptions
import me.lincolnstuart.funblocks.essentials.misc.chat.utils.ChatMessageOrientation
import me.lincolnstuart.funblocks.sample.components.Playground

class ChatMessageScreen : Screen {

    @Composable
    override fun Content() {
        var options: ChatMessageOptions by remember {
            mutableStateOf(ChatMessageOptions(orientation = ChatMessageOrientation.Sent))
        }
        Playground(component = {
            ChatMessage(
                message = "Chat message",
                options = options
            )
        }) {
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
