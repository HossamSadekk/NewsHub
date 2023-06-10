package com.example.on_boarding.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.NavigationManager
import com.OnBoardingDirections
import com.example.on_boarding.domain.use_case.SaveOnBoardingStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val saveOnBoardingStateUseCase: SaveOnBoardingStateUseCase
) : ViewModel() {
    fun navigateToHomeScreen(){
        saveOnBoardingState(state = true)
        // navigate to home page
        navigationManager.navigate(OnBoardingDirections.homeScreen)
    }
    fun saveOnBoardingState(state: Boolean) {
        viewModelScope.launch {
            saveOnBoardingStateUseCase(state)
        }
    }
}