
pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
    }
}
rootProject.name = "todomanager"


enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":lint")

include(":app")

include(":core:data")
include(":core:model")
include(":core:ui")
include(":core:database")
include(":core:designsystem")
include(":core:domain")

include(":feature:splash")
include(":feature:onboarding")
include(":core:common")
