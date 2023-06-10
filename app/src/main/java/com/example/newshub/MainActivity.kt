package com.example.newshub

import android.os.Bundle
import android.util.Log
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.rememberNavController
import com.NavigationManager
import com.OnBoardingDirections
import com.SplashScreenDirections
import com.example.newshub.navigation.RootNavigationGraph
import com.example.newshub.ui.theme.NewsHubTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsHubTheme {
                val navController = rememberNavController()
                /**
                 * here i used LaunchEffect because when recomposition happened the nav graph was not
                 * initialized yet so it throw a null pointer exception when navController try to navigate
                 * **/
                LaunchedEffect(navigationManager.commands) {

                    navigationManager.commands.collect { command ->
                        if (
                            command.destination.isNotEmpty()
                        ) {
                            navController.navigate(command.destination){
                                navController.popBackStack(SplashScreenDirections.splashScreen.destination, true)
                                // Clear the back stack up to the OnBoarding screen
                                navController.popBackStack(OnBoardingDirections.onBoarding.destination, true)
                                // Clear the back stack
                                launchSingleTop = true
                                restoreState = true
                            }

                        }
                    }
                }
                RootNavigationGraph(navController)
            }
        }
    }
}



