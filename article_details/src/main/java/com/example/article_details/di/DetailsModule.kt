package com.example.article_details.di

import com.example.article_details.data.repository.ArticleDetailsRepoImpl
import com.example.article_details.domain.repository.ArticleDetailsRepository
import com.example.database.dao.ArticleFavoriteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DetailsModule {
    @Provides
    @Singleton
    fun provideArticleDetailsRepository(dao: ArticleFavoriteDao):ArticleDetailsRepository =
        ArticleDetailsRepoImpl(dao)
}