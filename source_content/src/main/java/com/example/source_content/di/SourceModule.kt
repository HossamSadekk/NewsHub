package com.example.source_content.di

import com.example.remote.service.NewsApi
import com.example.source_content.data.repository.SourceRepositoryImpl
import com.example.source_content.domain.repository.SourceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SourceModule {
    @Provides
    @Singleton
    fun provideSourceRepository(api: NewsApi): SourceRepository =
        SourceRepositoryImpl(api)
}