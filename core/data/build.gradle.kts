plugins {
    alias(libs.plugins.basesolution.android.library)
    alias(libs.plugins.basesolution.hilt)
    id("kotlinx-serialization")
}

android {
    namespace = "ir.aratsoft.todomanager.core.data"
    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
}

dependencies {
//    api(projects.core.common)
    api(projects.core.database)
    api(libs.androidx.dataStore)

    implementation (libs.androidx.appcompat)
    implementation(libs.kotlinx.coroutines.core)
//    implementation(projects.core.common)
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.androidx.lifecycle.runtime.ktx)
//
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.hilt.android.testing)
    testImplementation(libs.kotlin.test)
//    testImplementation(libs.kotlinx.serialization.json)

}