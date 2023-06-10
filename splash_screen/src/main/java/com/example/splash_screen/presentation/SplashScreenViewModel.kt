package com.example.splash_screen.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.NavigationManager
import com.SplashScreenDirections
import com.example.splash_screen.domain.use_case.GetOnBoardingStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val getOnBoardingStateUseCase: GetOnBoardingStateUseCase
) : ViewModel() {
    fun navigate() {
        viewModelScope.launch {
            getOnBoardingStateUseCase().collect() { state ->
                if (state) {
                    // it means that user already saw the on boarding screen
                    Log.d("TAG", "--")
                } else {
                    Log.d("TAG", "false")
                    navigationManager.navigate(SplashScreenDirections.onBoarding)
                }
            }
        }
    }


}