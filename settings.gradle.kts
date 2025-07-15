pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {

    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "todomanager"


enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":core:data")
include(":core:model")
include(":core:ui")
include(":core:database")
include(":core:common")
include(":core:domain")
include(":core:datastore")
include(":core:designsystem")

include(":lint")

//include(":feature:home")
//include(":feature:dailyTask")
include(":feature:splash")
