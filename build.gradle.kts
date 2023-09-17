// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") apply false
    id("org.jetbrains.kotlin.android") apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
    id("com.android.library") apply false
    id("workplaces.root-project")
}

workplaces {
    minSdk.set(27)
    targetSdk.set(34)
}