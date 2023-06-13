import java.awt.SplashScreen

object SupportLib {
    const val CoreKtx = "androidx.core:core-ktx:1.7.0"
    const val LifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
    const val LifecycleRuntimeCompose = "androidx.lifecycle:lifecycle-runtime-compose:2.6.0-beta01"
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
object Pager {
    const val ComposePager = "com.google.accompanist:accompanist-pager:0.23.1"
    const val HorizontalPagerIndicator  = "com.google.accompanist:accompanist-pager-indicators:0.23.1"
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
object Local {
    const val Preferences_DataStore = "androidx.datastore:datastore-preferences:1.0.0"
}

object Remote {
    const val retrofit2 = "com.squareup.retrofit2:retrofit:2.7.2"
    const val retrofit2_converter = "com.squareup.retrofit2:converter-gson:2.7.2"
    const val okhttp3 = "com.squareup.okhttp3:okhttp:3.6.0"
}

object Logger {
    const val Timber = "com.jakewharton.timber:timber:5.0.1"
}

object Modules {
    const val APP = ":app"
    const val Theme = ":core:theme"
    const val STORAGE = ":core:local:storage"
    const val NAVIGATION = ":navigation"
    const val SPLASHSCREEN = ":splash_screen"
    const val ONBOARDING = ":on_boarding"
    const val Home = ":home"
    const val REMOTE = ":core:remote"
    const val MODEL = ":core:model"
}