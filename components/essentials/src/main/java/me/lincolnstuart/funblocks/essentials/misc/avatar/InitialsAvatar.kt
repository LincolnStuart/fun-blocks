package me.lincolnstuart.funblocks.essentials.misc.avatar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.lincolnstuart.funblocks.core.text.Text
import me.lincolnstuart.funblocks.core.text.utils.TextMode
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarOptions
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarShape
import me.lincolnstuart.funblocks.essentials.misc.avatar.utils.AvatarSize
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

/**
 * Avatar with name initials. Based on [BasicAvatar]. The initials are from first and last name.
 * E.g "Lincoln Middle Name Stuart" -> LS
 *
 * @param fullName an user full name.
 * @param modifier optional [Modifier].
 * @param options [AvatarOptions].
 */
@Composable
public fun InitialsAvatar(
    fullName: String,
    modifier: Modifier = Modifier,
    options: AvatarOptions = AvatarOptions()
) {
    val splittedNames: List<String> = remember(fullName) {
        fullName.uppercase().split(" ")
    }
    val initials: String = remember(fullName) {
        if (splittedNames.size <= 1) {
            splittedNames.firstOrNull()?.firstOrNull()?.toString().orEmpty()
        } else {
            "${splittedNames.first().first()}${splittedNames.last().first()}"
        }
    }
    BasicAvatar(
        options = options,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = initials,
                modifier = Modifier.padding(all = FunBlocksSpacing.xxxSmall),
                mode = TextMode.Custom(fontSize = options.size.fontSize),
                color = FunBlocksColors.NeutralDark
            )
        }
    }
}

@Preview
@Composable
private fun InitialsAvatarPreview() {
    FunBlocksTheme {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                InitialsAvatar(
                    fullName = "Lincoln Some Middle Name Stuart",
                    modifier = Modifier.padding(all = FunBlocksSpacing.xxxSmall),
                    options = AvatarOptions(
                        shape = AvatarShape.Circle,
                        size = AvatarSize.Regular
                    )
                )
                InitialsAvatar(
                    fullName = "Lincoln",
                    modifier = Modifier.padding(all = FunBlocksSpacing.xxxSmall),
                    options = AvatarOptions(
                        shape = AvatarShape.Circle,
                        size = AvatarSize.Large
                    )
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                InitialsAvatar(
                    fullName = "Lincoln Some Middle Name Stuart",
                    modifier = Modifier.padding(all = FunBlocksSpacing.xxxSmall),
                    options = AvatarOptions(
                        shape = AvatarShape.Square,
                        size = AvatarSize.Regular
                    )
                )
                InitialsAvatar(
                    fullName = "Lincoln",
                    modifier = Modifier.padding(all = FunBlocksSpacing.xxxSmall),
                    options = AvatarOptions(
                        shape = AvatarShape.Square,
                        size = AvatarSize.Large
                    )
                )
            }
        }
    }
}
