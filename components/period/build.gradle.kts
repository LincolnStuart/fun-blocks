plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.compose)
}

android {
    namespace = AndroidBuild.nameSpace(moduleName = "period")
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
    android {
        compilations.all {
            kotlinOptions.jvmTarget = AndroidBuild.jvmTarget
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.ui)
                implementation(compose.material)
                implementation(compose.uiTooling)
                implementation(libs.compose.icons)
                implementation(libs.kotlinx.datetime)
                implementation(project(":foundation"))
                implementation(project(":components:core"))
            }
        }
        val androidMain by getting {
            dependencies { }
        }
    }
}

dependencies {
    coreLibraryDesugaring(libs.desugar)
}
