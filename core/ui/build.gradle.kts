plugins {
    alias(libs.plugins.basesolution.android.library)
    alias(libs.plugins.basesolution.android.library.compose)
}

android {
    namespace = "ir.aratsoft.todomanager.core.ui"
}

dependencies {
    api(libs.androidx.metrics)
    api(projects.core.model)

    implementation(libs.androidx.browser)
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)

}