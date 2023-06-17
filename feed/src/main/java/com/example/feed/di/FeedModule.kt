package com.example.feed.di

import com.example.feed.data.repository.FeedRepositoryImpl
import com.example.feed.domain.repository.FeedRepository
import com.example.remote.service.NewsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FeedModule {
    @Provides
    @Singleton
    fun provideFeedRepository(api: NewsApi):FeedRepository =
        FeedRepositoryImpl(api)
}