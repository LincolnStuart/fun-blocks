package me.lincolnstuart.funblocks.sample.screens.misc

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.essentials.misc.banner.Banner
import me.lincolnstuart.funblocks.sample.components.Playground

class BannerScreen : Screen {

    @Composable
    override fun Content() {
        Playground(component = {
            Banner(
                url = "https://media.istockphoto.com/id/1318606676/vector/pattern-of-different-" +
                    "colorful-toy-bricks-in-isometric-view-vector-stock-illustration.jpg" +
                    "?s=612x612&w=0&k=20&c=nfJxJguqUqykTuQO-2SiU6Eh9uybMiP0n9ovYu-6mcY="
            ) {}
        }) {}
    }
}
