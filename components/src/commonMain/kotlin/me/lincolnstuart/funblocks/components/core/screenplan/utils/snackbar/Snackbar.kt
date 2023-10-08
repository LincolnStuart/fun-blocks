package me.lincolnstuart.funblocks.components.core.screenplan.utils.snackbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import kotlinx.coroutines.delay
import me.lincolnstuart.funblocks.components.core.text.Text
import me.lincolnstuart.funblocks.components.core.text.utils.TextMode
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksInset
import kotlin.time.Duration.Companion.seconds

@Composable
public fun Snackbar(
    options: SnackbarOptions,
    disableMessage: () -> Unit
) = with(options) {
    var remainingSeconds by remember(options) { mutableStateOf(showTimeInSeconds) }
    val isDisabled = remember(remainingSeconds) {
        remainingSeconds <= 0
    }
    if (isDisabled) disableMessage()
    Row(
        modifier = Modifier
            .background(color = FunBlocksColors.PrimaryDark.value())
            .padding(paddingValues = FunBlocksInset.large)
            .fillMaxWidth()
    ) {
        Text(
            text = message,
            color = FunBlocksColors.Reversed,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            mode = TextMode.Subtitle()
        )
    }
    LaunchedEffect(isDisabled.not()) {
        while (remainingSeconds > 0) {
            delay(1.seconds)
            remainingSeconds--
        }
    }
}
