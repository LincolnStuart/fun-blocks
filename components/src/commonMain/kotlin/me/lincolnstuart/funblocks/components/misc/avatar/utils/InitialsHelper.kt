package me.lincolnstuart.funblocks.components.misc.avatar.utils

internal object InitialsHelper {

    internal fun getInitials(fullName: String): String {
        val splittedNames: List<String> = fullName.uppercase().split(" ")
        return if (splittedNames.size <= 1) {
            splittedNames.firstOrNull()?.firstOrNull()?.toString().orEmpty()
        } else {
            "${splittedNames.first().first()}${splittedNames.last().first()}"
        }
    }
}
