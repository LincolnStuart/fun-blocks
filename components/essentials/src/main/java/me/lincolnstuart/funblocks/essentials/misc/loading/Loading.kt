package me.lincolnstuart.funblocks.essentials.misc.loading

import androidx.compose.animation.core.InfiniteTransition
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import me.lincolnstuart.funblocks.foundation.ui.theme.LocalTheme
import me.lincolnstuart.funblocks.foundation.ui.token.content.size.FunBlocksContentSize

/**
 * Simple loading that pulsate app logo setup on theme.
 */
@Composable
public fun Loading() {
    val logo = painterResource(id = LocalTheme.current.logoId)
    val infiniteTransition = rememberInfiniteTransition()
    val scale by scaleAnimation(infiniteTransition)
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = logo,
            contentDescription = null,
            modifier = Modifier
                .scale(scale = scale)
                .width(FunBlocksContentSize.huge)
        )
    }
}

@Composable
private fun scaleAnimation(infiniteTransition: InfiniteTransition) =
    infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        )
    )