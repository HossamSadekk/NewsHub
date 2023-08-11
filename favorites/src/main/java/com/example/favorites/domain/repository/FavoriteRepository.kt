package com.example.favorites.domain.repository

import com.example.model.dto.article.ArticleDto

interface FavoriteRepository {
    suspend fun getAllFavorites(): List<ArticleDto>
}