package com.example.newshub.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.HomeScreenDirections
import com.example.home.HomeScreen

fun NavGraphBuilder.homeNavGraph() {
    navigation(
        route = HomeScreenDirections.root.destination,
        startDestination = HomeScreenDirections.homeScreen.destination
    ){
        composable(HomeScreenDirections.homeScreen.destination) {
            HomeScreen()
        }
    }
}