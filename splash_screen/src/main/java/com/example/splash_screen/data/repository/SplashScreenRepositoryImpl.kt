package com.example.splash_screen.data.repository

import com.example.splash_screen.domain.repository.SplashScreenRepository
import com.example.storage.pref.PreferencesManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SplashScreenRepositoryImpl @Inject constructor(private val preferencesManager: PreferencesManager) :
    SplashScreenRepository {
    override suspend fun getOnBoardingState(): Flow<Boolean> {
        return preferencesManager.readOnBoardingState()
    }
}