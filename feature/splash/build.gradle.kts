plugins {
    alias(libs.plugins.basesolution.android.feature)
    alias(libs.plugins.basesolution.android.library.compose)
}

android {
    namespace = "ir.aratsoft.splash"
}

dependencies {

    api(projects.core.data)
//    api(libs.androidx.compose.foundation)
//    api(libs.androidx.compose.foundation.layout)
    implementation(projects.core.datastore)

    androidTestImplementation(libs.bundles.androidx.compose.ui.test)
}