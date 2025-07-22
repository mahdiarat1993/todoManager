plugins {
    alias(libs.plugins.basesolution.android.library)
}

android {
    namespace = "ir.aratsoft.todomanager.core.domain"
}

dependencies {

    api(projects.core.data)
    api(projects.core.model)

    implementation(libs.javax.inject)

}