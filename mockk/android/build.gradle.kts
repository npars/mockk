import io.mockk.dependencies.Deps
import io.mockk.dependencies.kotlinVersion

plugins {
    id("mpp-android")
}

extra["mavenName"] = "MockK Android"
extra["mavenDescription"] = "mocking library for Kotlin (Android instrumented test)"

apply(from = "${rootProject.extensions.extraProperties["gradles"]}/upload.gradle")

android {
    compileSdkVersion("android-31")


    lintOptions {
        isAbortOnError = false
        disable("InvalidPackage")
        warning("NewApi")
    }

    packagingOptions {
        exclude("META-INF/main.kotlin_module")
        exclude("META-INF/LICENSE.md")
        exclude("META-INF/LICENSE-notice.md")
    }

    defaultConfig {
        minSdk = 21
        targetSdk = 31
        versionName = "${project.version}"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments
        testInstrumentationRunnerArguments["notAnnotation"] = "io.mockk.test.SkipInstrumentedAndroidTest"
    }

    sourceSets {
        getByName("androidTest").assets.srcDirs("$projectDir/common/src/test/kotlin")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}

// very weird hack to make it working in IDE (check settings.gradle)
val mockKProject = findProject(":mockk-jvm")?.project ?: project(":mockk")

dependencies {
    api(project(":${mockKProject.name}")) {
        exclude(group = "io.mockk", module = "mockk-agent-jvm")
    }
    implementation(project(":mockk-agent-android"))
    implementation(project(":mockk-agent-api"))

    testImplementation("junit:junit:4.13.1")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.2") {
        exclude(group = "com.android.support", module = "support-annotations")
    }
    androidTestImplementation(Deps.Libs.kotlinReflect(kotlinVersion()))
    androidTestImplementation(Deps.Libs.kotlinCoroutinesCore())
    androidTestImplementation(Deps.Libs.kotlinTestJunit()) {
        exclude(group = "junit", module = "junit")
    }
    androidTestImplementation("com.android.support.test:rules:1.0.2")

    androidTestImplementation(Deps.Libs.junitJupiterApi)
    androidTestImplementation(Deps.Libs.junitJupiterEngine)
    androidTestImplementation(Deps.Libs.junitVintageEngine)
}

