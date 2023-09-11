plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.splash_screen"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
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
    implementation(Animation.Lottie)
    androidTestImplementation(SupportLib.ComposeUijunit4)
    implementation(project(Modules.STORAGE))
    implementation(project(Modules.COMMON))
    implementation(project(mapOf("path" to ":navigation")))
    implementation("androidx.test.ext:junit-ktx:1.1.5")
    testImplementation(TestingLib.mockk)
    androidTestImplementation("io.mockk:mockk-android:1.12.3")

    testImplementation(TestingLib.Junit)
    testImplementation(AndroidTestingLib.JunitExt)
    testImplementation(AndroidTestingLib.EspressoCore)
    testImplementation(AndroidTestingLib.ComposeTestJunit)
    testImplementation(AndroidTestingLib.JunitExt)
    androidTestImplementation("junit:junit:4.12")
    debugImplementation(AndroidComposeDebugLib.ComposeUiTooling)
    debugImplementation(AndroidComposeDebugLib.UiTestManifest)

    implementation(Navigation.NavigationCompose)
    implementation(DI.Hilt)
    implementation(DI.Hilt_Navigation)
    kapt(DI.Hilt_Compiler)


    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))

}