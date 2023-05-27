package me.lincolnstuart.funblocks.sample.screens.misc.avatar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.core.surface.Surface
import me.lincolnstuart.funblocks.essentials.form.radiobutton.RadioButtonGroup
import me.lincolnstuart.funblocks.essentials.misc.accordion.Accordion
import me.lincolnstuart.funblocks.essentials.misc.avatar.InitialsAvatar
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarOptions
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarShape
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarSize
import me.lincolnstuart.funblocks.essentials.misc.divider.HorizontalDivider
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors

class InitialsAvatarScreen : Screen {

    @Composable
    override fun Content() {
        FunBlocksTheme {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                InitialsAvatarPlayground()
            }
        }
    }

    @Composable
    private fun InitialsAvatarPlayground() {
        var shape by remember {
            mutableStateOf(AvatarShape.Circle)
        }
        var size by remember {
            mutableStateOf(AvatarSize.Regular)
        }
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                FunBlocksColors.Surface.value(),
                                FunBlocksColors.SurfaceDark.value()
                            )
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                InitialsAvatar(
                    fullName = "Lincoln Stuart",
                    options = AvatarOptions(shape, size)
                )
            }
            HorizontalDivider()
            Accordion(title = "Shape") {
                RadioButtonGroup(
                    options = listOf(AvatarShape.Circle, AvatarShape.Square),
                    selectedOption = shape,
                    onSelectOption = { shape = it }
                ) {
                    Text(text = it.name)
                }
            }
            Accordion(title = "Size") {
                RadioButtonGroup(
                    options = listOf(
                        AvatarSize.Small,
                        AvatarSize.Regular,
                        AvatarSize.Large
                    ),
                    selectedOption = size,
                    onSelectOption = { size = it }
                ) {
                    Text(text = it.name)
                }
            }
        }
    }
}
