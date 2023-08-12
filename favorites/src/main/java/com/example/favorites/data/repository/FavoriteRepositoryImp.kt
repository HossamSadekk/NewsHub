package com.example.favorites.data.repository

import com.example.database.dao.ArticleFavoriteDao
import com.example.favorites.domain.repository.FavoriteRepository
import com.example.model.local.article.ArticleEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteRepositoryImp @Inject constructor(private val dao: ArticleFavoriteDao) :
    FavoriteRepository {
    override suspend fun getAllFavorites(): Flow<List<ArticleEntity>> =
        dao.getAllFavoriteArticles()
}