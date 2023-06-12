package com.example.newshub.di

import com.example.newshub.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    @Named("isDebug")
    fun provideIsDebug(): Boolean {
        return BuildConfig.DEBUG
    }
}