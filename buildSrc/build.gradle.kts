plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
}

gradlePlugin {
    plugins {
        create("root-project") {
            id = "workplaces.root-project"
            implementationClass = "RootProjectPlugin"
        }
        create("sdk-version") {
            id = "workplaces.sdk-version"
            implementationClass = "SdkVersionPlugin"
        }
    }
}

dependencies {

    implementation("com.android.tools.build:gradle:8.1.1")
    implementation(kotlin("gradle-plugin"))
    implementation("com.squareup:javapoet:1.13.0")
}
