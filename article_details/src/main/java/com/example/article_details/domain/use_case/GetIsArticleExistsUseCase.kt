package com.example.article_details.domain.use_case

import com.example.article_details.domain.repository.ArticleDetailsRepository
import javax.inject.Inject

class GetIsArticleExistUseCase @Inject constructor(private val repo: ArticleDetailsRepository) {
    suspend operator fun invoke(article: String): Boolean = repo.isArticleExist(article)
}