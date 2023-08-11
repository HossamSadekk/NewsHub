package com.example.favorites.data.repository

import com.example.database.dao.ArticleFavoriteDao
import com.example.favorites.domain.repository.FavoriteRepository
import com.example.model.dto.article.ArticleDto
import com.example.model.dto.toFavoriteDtoList
import javax.inject.Inject

class FavoriteRepositoryImp @Inject constructor(private val dao: ArticleFavoriteDao) :
    FavoriteRepository {
    override suspend fun getAllFavorites(): List<ArticleDto> =
        dao.getAllFavoriteArticles().toFavoriteDtoList()
}