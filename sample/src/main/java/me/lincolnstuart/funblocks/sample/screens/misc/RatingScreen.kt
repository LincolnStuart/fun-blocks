package me.lincolnstuart.funblocks.sample.screens.misc

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.essentials.misc.rating.Rating
import me.lincolnstuart.funblocks.sample.components.Playground

class RatingScreen : Screen {

    @Composable
    override fun Content() {
        var grade by remember {
            mutableStateOf(0)
        }
        Playground(component = {
            Rating(grade = grade) { updated ->
                grade = updated
            }
        }) {}
    }
}
