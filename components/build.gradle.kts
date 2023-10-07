plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.compose)
}

val moduleName = "components"

android {
    namespace = AndroidBuild.nameSpace(moduleName = moduleName)
    compileSdk = AndroidBuild.compileSdk
    defaultConfig {
        minSdk = AndroidBuild.minSdk
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = false
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

    ios()
    iosSimulatorArm64()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = moduleName
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.ui)
                implementation(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                // implementation(compose.uiTooling)
                implementation(libs.compose.icons)
                implementation(libs.kotlinx.datetime)
                implementation(projects.foundation)
            }
        }
    }
}

dependencies {
    coreLibraryDesugaring(libs.desugar)
}
