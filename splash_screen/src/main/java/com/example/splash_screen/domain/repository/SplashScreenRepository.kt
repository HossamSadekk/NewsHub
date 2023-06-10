package com.example.splash_screen.domain.repository

import kotlinx.coroutines.flow.Flow

interface SplashScreenRepository {
    suspend fun getOnBoardingState(): Flow<Boolean>
}