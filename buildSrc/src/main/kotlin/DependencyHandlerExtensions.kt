import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

interface Module {
    val name: String
}

open class Kapt(override val name: String) : Module
open class Implementation(override val name: String) : Module
open class Project(override val name: String) : Module

fun DependencyHandler.implementScope(vararg modules: Implementation) {
    modules.forEach { addModule(it.name) }
}

private fun DependencyHandler.addModule(name: String) {
    add("implementation", name)
}

fun DependencyHandler.featureScope(vararg modules: Project) {
    modules.forEach { addFeature(it.name) }
}

private fun DependencyHandler.addFeature(name: String) {
    add("implementation", project(name))
}

fun DependencyHandler.kaptScope(vararg modules: Kapt) {
    modules.forEach { addKapt(it.name) }
}

private fun DependencyHandler.addKapt(name: String) {
    add("kapt", name)
}

sealed class Modules {

    object Core : Modules() {
        val presentation = Project(":core:presentation")
        val navigation = Project(":core:navigation")
    }

    object Feature : Modules() {
        val sleepingMode = Project(":feature:sleeping-mode")
        val stopwatch = Project(":feature:stopwatch")
        val timer = Project(":feature:timer")
        val clock = Project(":feature:clock")
        val alarm = Project(":feature:alarm")
    }

    object Compose : Modules() {
        val composeUi = Implementation("androidx.compose.ui:ui")
        val composeRuntime = Implementation("androidx.compose.runtime:runtime")
        val composeFoundation = Implementation("androidx.compose.foundation:foundation")
        val composeUiGraphics = Implementation("androidx.compose.ui:ui-graphics")
        val composePreview = Implementation("androidx.compose.ui:ui-tooling-preview")
        val composeMaterial = Implementation("androidx.compose.material3:material3")
        val composeActivity = Implementation("androidx.activity:activity-compose:1.7.2")
        val composeNavigation = Implementation("androidx.navigation:navigation-compose:2.7.2") //("androidx.hilt:hilt-navigation-compose:1.0.0")
    }

    object AndroidX : Modules() {
        val kotlinCore = Implementation("androidx.core:core-ktx:1.12.0")
        val lifecycleRuntime = Implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
        val viewModel = Implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    }

    object Dagger : Modules() {
        val hilt = Implementation("com.google.dagger:hilt-android:2.48")
        val compiler = Kapt("com.google.dagger:hilt-android-compiler:2.48")
    }

}

fun DependencyHandler.addCompose() {
    add("implementation", platform("androidx.compose:compose-bom:2023.08.00"))
    implementScope(
        Modules.Compose.composeActivity,
        Modules.Compose.composeMaterial,
        Modules.Compose.composeUi,
        Modules.Compose.composePreview,
        Modules.Compose.composeUiGraphics,
        Modules.Compose.composeNavigation,
        Modules.Compose.composeRuntime,
        Modules.Compose.composeFoundation
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

