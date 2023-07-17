package com.example.article_details.domain.repository

import com.example.model.local.article.ArticleEntity

interface ArticleDetailsRepository {
    suspend fun isArticleExist(article: String): Boolean

    suspend fun addArticle(articleEntity: ArticleEntity)

    suspend fun deleteFavorite(articleEntity: String)
}