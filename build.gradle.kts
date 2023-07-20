buildscript {
    dependencies {
        classpath(libs.kt.lint)
    }
}
 plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.jetbrains.compose) apply false
    alias(libs.plugins.detekt) apply true
}
subprojects {
    apply(from = "$rootDir/config/detekt/detekt.gradle")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}