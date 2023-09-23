plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.compose)
}

val moduleName = "playground"

android {
    namespace = AndroidBuild.nameSpace(moduleName = moduleName)
    compileSdk = AndroidBuild.compileSdk

    defaultConfig {
        applicationId = AndroidBuild.nameSpace(moduleName = moduleName)
        minSdk = AndroidBuild.minSdk
        targetSdk = AndroidBuild.compileSdk
        versionCode = AndroidBuild.versionCode
        versionName = AndroidBuild.versionName
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            // TODO solve r8 problem
            // Caused by: [CIRCULAR REFERENCE: java.lang.NullPointerException: Cannot invoke
            // "com.android.tools.r8.internal.x4.D()" because the return value of
            // "com.android.tools.r8.internal.U10.h()" is null]
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
            isShrinkResources = false
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility(JavaVersion.VERSION_11)
        targetCompatibility(JavaVersion.VERSION_11)
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.toString()
    }
    packaging {
        resources {
            excludes += AndroidBuild.packagesResourcesExcludes
        }
    }
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions.jvmTarget = AndroidBuild.jvmTarget
        }
    }

    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.splash.screen)
                implementation(libs.bundles.android.x)
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.ui)
                implementation(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                implementation(libs.compose.icons)
                implementation(libs.kotlinx.datetime)
                implementation(libs.voyager.navigator)
                implementation(projects.foundation)
                implementation(projects.components)
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "me.lincolnstuart.funblocks.playground.MainKt"
        nativeDistributions {
            packageName = moduleName
            packageVersion = "1.0.0"
            targetFormats(
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Dmg,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Msi,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Deb
            )
            /*macOS {
                iconFile.set(project.file("resources/icon.icns"))
            }
            windows {
                iconFile.set(project.file("resources/icon.ico"))
            }
            linux {
                iconFile.set(project.file("resources/icon.png"))
            }*/
        }
    }
}

dependencies {
    coreLibraryDesugaring(libs.desugar)
}
