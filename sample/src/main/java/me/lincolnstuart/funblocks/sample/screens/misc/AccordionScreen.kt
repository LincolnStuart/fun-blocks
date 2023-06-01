package me.lincolnstuart.funblocks.sample.screens.misc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.core.surface.Surface
import me.lincolnstuart.funblocks.essentials.misc.accordion.Accordion
import me.lincolnstuart.funblocks.essentials.misc.alert.Alert
import me.lincolnstuart.funblocks.essentials.misc.alert.utils.AlertMode
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

class AccordionScreen : Screen {

    @Composable
    override fun Content() {
        FunBlocksTheme {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                AccordionPlaygroundOptions()
            }
        }
    }

    @Composable
    private fun AccordionPlaygroundOptions() {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(color = FunBlocksColors.SurfaceMedium.value())
                    .padding(FunBlocksSpacing.small),
                contentAlignment = Alignment.Center
            ) {
                Accordion(title = "Accordion") {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .padding(FunBlocksSpacing.small)
                    ) {
                        Alert(title = "Content inside", mode = AlertMode.Warning)
                    }
                }
            }
        }
    }
}
