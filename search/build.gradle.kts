plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
    id("kotlin-android-extensions")
}

android {
    namespace = "com.example.search"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(SupportLib.CoreKtx)
    implementation(SupportLib.LifecycleRuntime)
    implementation(SupportLib.ActivityCompose)
    implementation(SupportLib.ComposeUi)
    implementation(SupportLib.ComposeUiToolingPreview)
    implementation(SupportLib.ComposeMaterial)
    implementation(SupportLib.ComposeLifecycle)

    implementation(project(Modules.MODEL))
    implementation(project(Modules.REMOTE))
    implementation(project(Modules.COMMON))
    implementation(project(mapOf("path" to ":navigation")))
    implementation(Remote.retrofit2_converter)

    implementation(DI.Hilt)
    implementation(DI.Hilt_Navigation)
    kapt(DI.Hilt_Compiler)
    implementation(ImageLoader.coil)
    implementation(Logger.Timber)

    testImplementation(TestingLib.mockwebserver)
    testImplementation(TestingLib.Junit)
    testImplementation(TestingLib.coroutines_test)
    testImplementation(TestingLib.mockk)
    testImplementation(AndroidTestingLib.JunitExt)

    implementation(Pagination.Paging)
    implementation(Pagination.Paging_compose)

    implementation(Remote.retrofit2)
    implementation(Remote.retrofit2_converter)
    implementation(Remote.okhttp3)

    testImplementation(TestingLib.turbine)


}