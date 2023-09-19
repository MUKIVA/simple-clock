plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-convention")
    id("workplaces.sdk-version")
}

android {
    namespace = "com.mukiva.clock"

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {

    addCompose()
    addTests()

}