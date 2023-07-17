package com.example.database.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.database.db.NewsHubDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, NewsHubDatabase::class.java, "news_database")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providesArticleFavoriteDao(db: NewsHubDatabase) =
        db.articleFavoriteDao()
}