package me.lincolnstuart.funblocks.components.misc.rating

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import compose.icons.TablerIcons
import compose.icons.tablericons.Star
import me.lincolnstuart.funblocks.components.core.icon.Icon
import me.lincolnstuart.funblocks.components.core.icon.utils.IconOptions
import me.lincolnstuart.funblocks.components.core.icon.utils.IconSize
import me.lincolnstuart.funblocks.components.core.spacer.HorizontalSpacer
import me.lincolnstuart.funblocks.components.core.spacer.VerticalSpacer
import me.lincolnstuart.funblocks.components.core.surface.Surface
import me.lincolnstuart.funblocks.foundation.ui.theme.FunBlocksTheme
import me.lincolnstuart.funblocks.foundation.ui.token.color.FunBlocksColors
import me.lincolnstuart.funblocks.foundation.ui.token.content.shape.FunBlocksCornerRadius
import me.lincolnstuart.funblocks.foundation.ui.token.content.spacing.FunBlocksSpacing

private const val NUMBER_OF_STARS = 5

/**
 * Selectable star rating.
 *
 * @param grade the previously rate value.
 * @param starBaseDescription star description.
 * @param starSize [IconSize].
 * @param onSelectGrade callback that executes when click is performed and returns the selected grade.
 */
@Composable
public fun Rating(
    grade: Int?,
    starBaseDescription: String? = null,
    starSize: IconSize = IconSize.Medium,
    onSelectGrade: (grade: Int) -> Unit
) {
    val validGrade = remember(grade) {
        grade ?: 0
    }
    Row {
        repeat(NUMBER_OF_STARS) { index ->
            val actualGrade = index + 1
            val color =
                if (actualGrade <= validGrade) FunBlocksColors.Primary else FunBlocksColors.SurfaceDark
            Icon(
                imageVector = TablerIcons.Star,
                options = IconOptions(
                    description = "${starBaseDescription.orEmpty()} $actualGrade",
                    size = starSize,
                    color = color
                ),
                modifier = Modifier
                    .clip(FunBlocksCornerRadius.full)
                    .clickable {
                        onSelectGrade(actualGrade)
                    }
            )
            if (index != NUMBER_OF_STARS - 1) {
                HorizontalSpacer(width = FunBlocksSpacing.xSmall)
            }
        }
    }
}

// @Preview
@Composable
private fun RatingPreview() {
    FunBlocksTheme {
        Surface {
            Column(modifier = Modifier.padding(FunBlocksSpacing.small)) {
                Rating(grade = null) {}
                VerticalSpacer(height = FunBlocksSpacing.small)
                Rating(grade = 1) {}
                VerticalSpacer(height = FunBlocksSpacing.small)
                Rating(grade = 2) {}
                VerticalSpacer(height = FunBlocksSpacing.small)
                Rating(grade = 3) {}
                VerticalSpacer(height = FunBlocksSpacing.small)
                Rating(grade = 4) {}
                VerticalSpacer(height = FunBlocksSpacing.small)
                Rating(grade = 5) {}
            }
        }
    }
}
