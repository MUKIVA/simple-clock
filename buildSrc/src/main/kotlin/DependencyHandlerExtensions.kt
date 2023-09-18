import org.gradle.api.artifacts.dsl.DependencyHandler

interface Module {
    val name: String
}

open class Kapt(override val name: String) : Module
open class Implementation(override val name: String) : Module

fun DependencyHandler.implementScope(vararg modules: Implementation) {
    modules.forEach { addModule(it.name) }
}

private fun DependencyHandler.addModule(name: String) {
    add("implementation", name)
}

fun DependencyHandler.kaptScope(vararg modules: Kapt) {
    modules.forEach { addKapt(it.name) }
}

private fun DependencyHandler.addKapt(name: String) {
    add("kapt", name)
}

sealed class Modules {

    object Compose : Modules() {
        val composeUi = Implementation("androidx.compose.ui:ui")
        val composeUiGraphics = Implementation("androidx.compose.ui:ui-graphics")
        val composePreview = Implementation("androidx.compose.ui:ui-tooling-preview")
        val composeMaterial = Implementation("androidx.compose.material3:material3")
        val composeActivity = Implementation("androidx.activity:activity-compose:1.7.2")
        val composeNavigation = Implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    }

    object AndroidX : Modules() {
        val kotlinCore = Implementation("androidx.core:core-ktx:1.9.0")
        val lifecycleRuntime = Implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    }

    object Dagger : Modules() {
        val hilt = Implementation("com.google.dagger:hilt-android:2.48")
        val compiler = Kapt("com.google.dagger:hilt-android-compiler:2.48")
    }

}

fun DependencyHandler.addCompose() {
    add("implementation", platform("androidx.compose:compose-bom:2023.03.00"))
    implementScope(
        Modules.Compose.composeActivity,
        Modules.Compose.composeMaterial,
        Modules.Compose.composeUi,
        Modules.Compose.composePreview,
        Modules.Compose.composeUiGraphics,
        Modules.Compose.composeNavigation
    )
}

fun DependencyHandler.addDagger() {
    implementScope(
        Modules.Dagger.hilt
    )
    kaptScope(
        Modules.Dagger.compiler
    )
}

fun DependencyHandler.addTests() {
    add("testImplementation", "junit:junit:4.13.2")
    add("androidTestImplementation","androidx.test.ext:junit:1.1.5")
    add("androidTestImplementation", "androidx.test.espresso:espresso-core:3.5.1")
    add("androidTestImplementation", platform("androidx.compose:compose-bom:2023.03.00"))
    add("androidTestImplementation", "androidx.compose.ui:ui-test-junit4")
    add("debugImplementation","androidx.compose.ui:ui-tooling")
    add("debugImplementation", "androidx.compose.ui:ui-test-manifest")
}

