plugins {
    alias(libs.plugins.basesolution.android.library)
    alias(libs.plugins.basesolution.hilt)
    id("kotlinx-serialization")
}

android {
    namespace = "ir.aratsoft.todomanager.core.data"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    api(projects.core.data)
    api(projects.core.model)

    implementation(libs.javax.inject)
}