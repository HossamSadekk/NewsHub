package com.example.article_details.ui

import com.example.model.dto.article.ArticleDto
import com.example.model.dto.sources.SourceDto
import com.example.model.local.article.ArticleEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow


sealed class ArticleDetailsEvent {
    object popUp : ArticleDetailsEvent()
    data class checkArticleAvilability(val article: String) : ArticleDetailsEvent()
    data class updateArticleFavoriteState(val article: ArticleEntity) : ArticleDetailsEvent()
}