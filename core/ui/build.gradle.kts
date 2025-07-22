plugins {
    alias(libs.plugins.basesolution.android.library)
    alias(libs.plugins.basesolution.android.library.compose)
}

android {
    namespace = "ir.aratsoft.todomanager.core.ui"
}

dependencies {

    api(libs.androidx.metrics)
    api(projects.core.designsystem)
    api(projects.core.model)
    api(projects.core.common )

    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)

    testImplementation(libs.androidx.compose.ui.test)
    testImplementation(libs.androidx.compose.ui.testManifest)
}