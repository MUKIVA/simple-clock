plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-convention")
    id("workplaces.sdk-version")
}

android {
    namespace = "com.mukiva.presentation"
}

dependencies {
    implementScope(
        Modules.AndroidX.kotlinCore,
        Modules.AndroidX.lifecycleRuntime,
        Modules.AndroidX.viewModel
    )
}