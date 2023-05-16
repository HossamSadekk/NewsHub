package com.example.newshub.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.SplashScreenDirections
import com.example.splash_screen.SplashScreen

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = SplashScreenDirections.root.destination,
        startDestination = SplashScreenDirections.splashScreen.destination
    ) {
        composable(SplashScreenDirections.splashScreen.destination) {
            SplashScreen()
        }
    }
}