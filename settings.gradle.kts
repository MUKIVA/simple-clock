@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Simple Clock"
include(":app")

include(":core:presentation")

include(":feature:sleeping-mode")
include(":feature:stopwatch")
include(":feature:timer")
include(":feature:clock")
include(":feature:alarm")
