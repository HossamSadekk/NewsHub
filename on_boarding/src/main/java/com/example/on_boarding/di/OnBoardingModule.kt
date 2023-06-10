package com.example.on_boarding.di

import com.example.on_boarding.data.repository.OnBoardingRepositoryImpl
import com.example.on_boarding.domain.repository.OnBoardingRepository
import com.example.storage.pref.PreferencesManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class OnBoardingModule {
    @Provides
    fun provideOnBoardingRepository(preferencesManager: PreferencesManager):OnBoardingRepository =
        OnBoardingRepositoryImpl(preferencesManager)
}