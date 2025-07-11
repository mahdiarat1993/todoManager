plugins {
    alias(libs.plugins.basesolution.android.library)
    alias(libs.plugins.basesolution.android.room)
    alias(libs.plugins.basesolution.hilt)
    id("kotlinx-serialization")
}

android {
    namespace = "ir.aratsoft.todomanager.core.database"
}

dependencies {
    api(projects.core.model)

    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.serialization.json)

    androidTestImplementation(libs.androidx.test.core)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.kotlinx.coroutines.test)
}