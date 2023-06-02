package me.lincolnstuart.funblocks.sample.screens.misc

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.essentials.misc.accordion.Accordion
import me.lincolnstuart.funblocks.essentials.misc.alert.Alert
import me.lincolnstuart.funblocks.essentials.misc.alert.utils.AlertMode
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing
import me.lincolnstuart.funblocks.sample.components.Playground

class AccordionScreen : Screen {

    @Composable
    override fun Content() {
        Playground(component = {
            Accordion(title = "Accordion") {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(FunBlocksSpacing.small)
                ) {
                    Alert(title = "Content inside", mode = AlertMode.Warning)
                }
            }
        }) {}
    }
}
