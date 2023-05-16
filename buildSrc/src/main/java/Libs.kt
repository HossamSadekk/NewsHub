import java.awt.SplashScreen

object SupportLib {
    const val CoreKtx = "androidx.core:core-ktx:1.7.0"
    const val LifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
    const val ActivityCompose = "androidx.activity:activity-compose:1.3.1"
    const val ComposeUi = "androidx.compose.ui:ui:1.2.0"
    const val ComposeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:1.2.0"
    const val ComposeMaterial = "androidx.compose.material:material:1.2.0"
}
object TestingLib {
    const val Junit = "junit:junit:4.13.2"
}

object Animation {
    const val Lottie = "com.airbnb.android:lottie-compose:5.2.0"
}

object Navigation {
    const val NavigationCompose = "androidx.navigation:navigation-compose:2.5.3"
}

object AndroidTestingLib {
    const val JunitExt = "androidx.test.ext:junit:1.1.5"
    const val ComposeTestJunit = "androidx.compose.ui:ui-test-junit4:1.2.0"
    const val EspressoCore = "androidx.test.espresso:espresso-core:3.5.1"
}

object AndroidComposeDebugLib {
    const val ComposeUiTooling = "androidx.compose.ui:ui-tooling:1.2.0"
    const val UiTestManifest = "androidx.compose.ui:ui-test-manifest:1.2.0"
}

object DI {
    const val Hilt = "com.google.dagger:hilt-android:2.44"
    const val Hilt_Compiler = "com.google.dagger:hilt-android-compiler:2.44"
    const val Hilt_Navigation = "androidx.hilt:hilt-navigation-compose:1.0.0"
}


object Modules {
    const val APP = ":app"
    const val Theme = ":core:theme"
    const val NAVIGATION = ":navigation"
    const val SPLASHSCREEN = ":splash_screen"
}