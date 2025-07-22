plugins {
    alias(libs.plugins.basesolution.android.feature)
    alias(libs.plugins.basesolution.android.library.compose)
}

android {
    namespace = "ir.aratsoft.todomanager.feature.onboarding"
}

dependencies {
    api(projects.core.data)
    api(projects.core.domain)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    implementation(libs.lottie.compose)

    androidTestImplementation(libs.bundles.androidx.compose.ui.test)
}