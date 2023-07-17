package com.example.article_details.data.repository

import com.example.article_details.domain.repository.ArticleDetailsRepository
import com.example.database.dao.ArticleFavoriteDao
import com.example.model.local.article.ArticleEntity
import javax.inject.Inject

class ArticleDetailsRepoImpl @Inject constructor(private val dao: ArticleFavoriteDao) : ArticleDetailsRepository {
    override suspend fun isArticleExist(article: String): Boolean = dao.isArticleExists(article)

    override suspend fun addArticle(articleEntity: ArticleEntity) {
        dao.insertArticle(articleEntity)
    }

    override suspend fun deleteFavorite(title: String) {
        dao.deleteFavorite(title)
    }
}