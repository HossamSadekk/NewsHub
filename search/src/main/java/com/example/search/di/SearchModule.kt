package com.example.search.di

import com.example.remote.service.NewsApi
import com.example.search.data.repository.SearchRepositoryImpl
import com.example.search.domain.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SearchModule {
    @Provides
    @Singleton
    fun provideSearchRepository(api: NewsApi): SearchRepository =
        SearchRepositoryImpl(api)
}