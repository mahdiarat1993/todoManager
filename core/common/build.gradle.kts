plugins {
    alias(libs.plugins.basesolution.android.library)
//    alias(libs.plugins.basesolution.jvm.library)
//    alias(libs.plugins.basesolution.hilt)
}
android {
    namespace = "ir.aratsoft.common"
}
dependencies {
    implementation(libs.kotlinx.coroutines.core)
    testImplementation(libs.kotlinx.coroutines.test)
//    testImplementation(libs.turbine)
}
