package com.example.article_details.domain.use_case

import com.example.article_details.domain.repository.ArticleDetailsRepository
import com.example.model.local.article.ArticleEntity
import javax.inject.Inject

class UpdateFavoriteUseCase @Inject constructor(private val repo: ArticleDetailsRepository) {
    suspend operator fun invoke(article: ArticleEntity) {
        val isArticleExist = repo.isArticleExist(article.title)
        if (isArticleExist) {
            repo.deleteFavorite(article.title)
        } else {
            repo.addArticle(article)
        }
    }

}