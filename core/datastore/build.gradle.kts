plugins {
    alias(libs.plugins.basesolution.android.library)
    alias(libs.plugins.basesolution.hilt)
}
android {
    namespace = "ir.aratsoft.todomanager.core.datastore"

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }

}

dependencies {

    api(libs.androidx.dataStore)

    implementation(libs.kotlinx.coroutines.core)
    implementation(projects.core.common)
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.hilt.android.testing)
    testImplementation(libs.kotlin.test)
}