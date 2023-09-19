plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-convention")
    id("workplaces.sdk-version")
}

android {
    namespace = "com.mukiva.alarm"

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {

//    featureScope(
//        Modules.Core.navigation
//    )

    implementScope(
        Modules.AndroidX.kotlinCore,
        Modules.AndroidX.lifecycleRuntime
    )

    addCompose()
    addTests()

}