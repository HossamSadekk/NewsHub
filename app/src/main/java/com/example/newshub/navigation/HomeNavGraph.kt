package com.example.newshub.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.HomeScreenDirections
import com.example.article_details.ui.ArticleDetailsScreen
import com.example.common.mvvm.SharedViewModel
import com.example.home.HomeScreen
import com.example.model.dto.article.ArticleDto
import com.google.gson.Gson
import timber.log.Timber
import javax.inject.Inject
fun NavGraphBuilder.homeNavGraph(sharedViewModel: SharedViewModel) {

    navigation(
        route = HomeScreenDirections.root.destination,
        startDestination = HomeScreenDirections.homeScreen.destination
    ){
        composable(HomeScreenDirections.homeScreen.destination) {
            HomeScreen(sharedViewModel)
        }
        composable(HomeScreenDirections.detailsScreen().destination) {
       //     val result = navController.previousBackStackEntry?.savedStateHandle?.get<String>("argument")
         //   val gson = Gson()
           // val article = gson.fromJson(result, ArticleDto::class.java)
            ArticleDetailsScreen(sharedViewModel)
        }
    }
}