plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-convention")
    id("workplaces.sdk-version")
}

android {
    namespace = "com.mukiva.navigation"
}

dependencies {
    implementation("androidx.compose.ui:ui-graphics-android:1.5.1")
    implementScope(
        Modules.AndroidX.kotlinCore
    )
}