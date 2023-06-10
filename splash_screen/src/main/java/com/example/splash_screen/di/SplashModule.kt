package com.example.splash_screen.di

import com.example.splash_screen.data.repository.SplashScreenRepositoryImpl
import com.example.splash_screen.domain.repository.SplashScreenRepository
import com.example.storage.pref.PreferencesManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SplashModule {
    @Provides
    fun provideSplashRepository(preferencesManager: PreferencesManager):SplashScreenRepository =
        SplashScreenRepositoryImpl(preferencesManager)
}