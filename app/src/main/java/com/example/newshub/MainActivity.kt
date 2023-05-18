package com.example.newshub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.rememberNavController
import com.NavigationManager
import com.SplashScreenDirections
import com.example.newshub.navigation.RootNavigationGraph
import com.example.newshub.ui.theme.NewsHubTheme
import dagger.hilt.android.AndroidEntryPoint
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
                LaunchedEffect(navigationManager.commands) {
                    navigationManager.commands.collect { command ->
                        if (
                            command.destination.isNotEmpty()
                        ) {
                            navController.navigate(command.destination) {
                                popUpTo(SplashScreenDirections.splashScreen.destination) {
                                    inclusive = true
                                }
                            }
                        }
                    }
                }
                RootNavigationGraph(navController)
            }
        }
    }
}



