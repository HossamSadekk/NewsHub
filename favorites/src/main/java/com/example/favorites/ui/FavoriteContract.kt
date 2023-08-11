package com.example.favorites.ui

import com.example.model.dto.article.ArticleDto

data class FavoriteViewState(
    val articles: List<ArticleDto> = emptyList()
)

sealed class FavoriteEvent {
    object LoadArticles : FavoriteEvent()
    object NavigateToDetailsScreen : FavoriteEvent()
    object RefreshScreen : FavoriteEvent()

}