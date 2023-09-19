// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") apply false
    id("org.jetbrains.kotlin.android") apply false
    id("com.android.library") apply false
    id("workplaces.root-project")
    id("com.google.dagger.hilt.android") version "2.48" apply false
}

workplaces {
    minSdk.set(31)
    targetSdk.set(34)
}