package com.example.favorites.domain.repository

import com.example.model.local.article.ArticleEntity
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    suspend fun getAllFavorites(): Flow<List<ArticleEntity>>
}