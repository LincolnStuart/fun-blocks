plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
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
    kotlinOptions {
        jvmTarget = AndroidBuild.jvmTarget
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

dependencies {
    implementation(libs.splash.screen)
    implementation(libs.bundles.android.x)
    implementation(compose.runtime)
    implementation(compose.foundation)
    implementation(compose.ui)
    implementation(compose.material)
    implementation(compose.uiTooling)
    implementation(libs.compose.icons)
    implementation(libs.kotlinx.datetime)
    implementation(libs.voyager.navigator)
    implementation(projects.foundation)
    implementation(projects.components)
}

dependencies {
    coreLibraryDesugaring(libs.desugar)
}
