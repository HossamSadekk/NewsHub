package com.example.splash_screen.presentation

import androidx.lifecycle.ViewModel
import com.NavigationManager
import com.SplashScreenDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val navigationManager: NavigationManager
): ViewModel() {
    fun navigate(){
        navigationManager.navigate(SplashScreenDirections.onBoarding)
    }
}