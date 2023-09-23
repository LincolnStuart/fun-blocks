package me.lincolnstuart.funblocks.playground.screens.components.misc

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import me.lincolnstuart.funblocks.components.misc.banner.Banner
import me.lincolnstuart.funblocks.playground.components.Sample

class BannerScreen : Screen {

    @Composable
    override fun Content() {
        Sample(
            component = {
                Banner(
                    url = "https://media.istockphoto.com/id/1318606676/vector/pattern-of-different-" +
                        "colorful-toy-bricks-in-isometric-view-vector-stock-illustration.jpg" +
                        "?s=612x612&w=0&k=20&c=nfJxJguqUqykTuQO-2SiU6Eh9uybMiP0n9ovYu-6mcY="
                ) {}
            }
        ) {}
    }
}
