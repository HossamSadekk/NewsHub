package com.example.splash_screen.domain.use_case

import com.example.splash_screen.domain.repository.SplashScreenRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetOnBoardingStateUseCase @Inject constructor(private val repository: SplashScreenRepository) {
    suspend operator fun invoke(): Flow<Boolean> = repository.getOnBoardingState()
}