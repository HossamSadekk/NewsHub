package com.example.on_boarding.data.repository

import com.example.on_boarding.domain.repository.OnBoardingRepository
import com.example.storage.pref.PreferencesManager
import javax.inject.Inject

class OnBoardingRepositoryImpl @Inject constructor(private val preferencesManager: PreferencesManager) :
    OnBoardingRepository {
    override suspend fun saveOnBoardingState(state: Boolean) {
        preferencesManager.saveOnBoardingState(state)
    }
}