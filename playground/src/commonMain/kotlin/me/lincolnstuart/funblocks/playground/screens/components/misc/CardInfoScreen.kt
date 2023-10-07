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
import me.lincolnstuart.funblocks.components.core.screenplan.ScreenPlan
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.components.form.radiobutton.RadioButtonGroup
import me.lincolnstuart.funblocks.components.misc.accordion.Accordion
import me.lincolnstuart.funblocks.components.misc.cardinfo.CardInfo
import me.lincolnstuart.funblocks.components.misc.cardinfo.utils.CardBodyOptions
import me.lincolnstuart.funblocks.components.misc.cardinfo.utils.CardHeaderOptions
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize
import me.lincolnstuart.funblocks.playground.components.ComponentWithOptions
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

class CardInfoScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val bodyOptions = getBodyOptions()
        var bodyOption: CardBodyOptions by remember {
            mutableStateOf(bodyOptions.first())
        }
        var headerOption: CardHeaderOptions? by remember {
            mutableStateOf(null)
        }
        ScreenPlan(
            appBarOptions = AppBarOptions(
                mainContent = { Text(text = "CardInfo", mode = TextMode.Subtitle()) },
                mainAction = AppBarAction(icon = TablerIcons.ArrowLeft, description = null) {
                    navigator.pop()
                }
            ),
            content = {
                ComponentWithOptions(mainContent = {
                    CardInfo(
                        body = bodyOption,
                        header = headerOption
                    )
                }) {
                    Accordion(title = "Header") {
                        RadioButtonGroup(
                            options = getHeaderOptions(),
                            selectedOption = headerOption,
                            onSelectOption = { headerOption = it }
                        ) {
                            Text(text = it?.javaClass?.simpleName ?: "None")
                        }
                    }
                    Accordion(title = "Body") {
                        RadioButtonGroup(
                            options = bodyOptions,
                            selectedOption = bodyOption,
                            onSelectOption = { bodyOption = it }
                        ) {
                            Text(text = it.javaClass.simpleName)
                        }
                    }
                }
            }
        )
    }

    @Composable
    @OptIn(ExperimentalResourceApi::class)
    private fun getHeaderOptions(): List<CardHeaderOptions?> {
        val fullHeader = CardHeaderOptions.Full(
            painter = painterResource("images/fun_blocks.webp"),
            title = "Full",
            height = FunBlocksContentSize.huge
        )
        val profileHeader = CardHeaderOptions.Profile(
            painter = painterResource("images/fun_blocks.webp"),
            title = "Profile"
        )
        return listOf(
            fullHeader,
            profileHeader,
            null
        )
    }

    @Composable
    private fun getBodyOptions(): List<CardBodyOptions> {
        val characteristicBody = CardBodyOptions.Characteristic(
            characteristics = mapOf(
                Pair("First name", "Lincoln"),
                Pair("Last name", "Stuart")
            )
        )
        val legendBody = CardBodyOptions.Legend(text = "Legend")
        val listingBody = CardBodyOptions.Listing(
            topics = listOf("Kotlin", "Android", "Jetpack Compose")
        )
        val customBody = CardBodyOptions.Custom(
            content = { Text(text = "Custom") }
        )
        return listOf(
            characteristicBody,
            legendBody,
            listingBody,
            customBody
        )
    }
}
