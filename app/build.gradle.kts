plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-convention")
    id("workplaces.sdk-version")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.mukiva.simpleclock"

    defaultConfig {
        applicationId = "com.mukiva.simpleclock"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    featureScope(
        Modules.Core.presentation,
        Modules.Core.navigation
    )

    implementScope(
        Modules.AndroidX.kotlinCore,
        Modules.AndroidX.lifecycleRuntime
    )

    addCompose()
    addTests()
    addDagger()
}

kapt {
    correctErrorTypes = true
}

hilt {
    enableAggregatingTask = true
}