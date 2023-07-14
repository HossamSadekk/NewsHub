package com.example.newshub.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.OnBoardingDirections
import com.SplashScreenDirections
import com.example.common.mvvm.SharedViewModel
import com.example.on_boarding.presentation.OnBoardingScreen
import com.example.splash_screen.SplashScreen

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    val sharedViewModel: SharedViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = SplashScreenDirections.root.destination
    ) {

        navigation(startDestination = SplashScreenDirections.splashScreen.destination,
        route = SplashScreenDirections.root.destination){
            composable(SplashScreenDirections.splashScreen.destination) {
                SplashScreen()

            }
            composable(OnBoardingDirections.onBoarding.destination) {
               OnBoardingScreen()
            }
            homeNavGraph(sharedViewModel)
        }

    }
}