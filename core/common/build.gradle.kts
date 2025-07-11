plugins {
    alias(libs.plugins.basesolution.jvm.library)
    alias(libs.plugins.basesolution.hilt)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.turbine)
}
