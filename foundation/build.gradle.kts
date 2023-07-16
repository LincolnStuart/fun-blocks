plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.compose)
}

apply(from = "$rootDir/config/detekt/detekt.gradle")

android {
    namespace = "me.lincolnstuart.funblocks.foundation"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        // targetSdk = 34

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(name = "proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    /*compileOptions {
        sourceCompatibility(JavaVersion.VERSION_17)
        targetCompatibility(JavaVersion.VERSION_17)
    }
    kotlinOptions {
        jvmTarget = '11'
    }
    buildFeatures {
        compose = true
    }*/
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kotlin {
    android()
    sourceSets {
        val commonMain by getting {
            dependencies {
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.android.x.core.ktx)
                implementation(libs.android.x.lifecycle.runtime.ktx)
                implementation(libs.bundles.compose)
                implementation(libs.material)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(libs.junit)
                implementation(libs.android.x.junit)
                implementation(libs.android.x.espresso.core)
                implementation(libs.compose.test)
            }
        }
        val androidDebug by getting {
            dependencies {
                implementation(libs.compose.tooling)
                implementation(libs.compose.test.manifest)
            }
        }
    }
}
