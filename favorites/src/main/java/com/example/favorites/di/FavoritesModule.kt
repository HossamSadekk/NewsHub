package com.example.favorites.di

import com.example.database.dao.ArticleFavoriteDao
import com.example.favorites.data.repository.FavoriteRepositoryImp
import com.example.favorites.domain.repository.FavoriteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FavoritesModule {
    @Provides
    @Singleton
    fun provideFavoriteRepository(dao: ArticleFavoriteDao): FavoriteRepository =
        FavoriteRepositoryImp(dao)
}