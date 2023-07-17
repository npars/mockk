val hiltVersion = "2.46.1"

plugins {
    buildsrc.convention.`android-library`
    id("com.google.dagger.hilt.android") version "2.46.1"
}

dependencies {
    testImplementation(projects.modules.mockk)
    testImplementation(projects.modules.mockkAndroid)

    implementation("androidx.core:core:1.10.1")

    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-compiler:$hiltVersion")
    testImplementation("com.google.dagger:hilt-android-testing:$hiltVersion")
    kaptTest("com.google.dagger:hilt-android-compiler:$hiltVersion")
    testAnnotationProcessor("com.google.dagger:hilt-android-compiler:$hiltVersion")
}
