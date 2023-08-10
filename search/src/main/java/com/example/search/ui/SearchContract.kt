package com.example.search.ui

import androidx.paging.PagingData
import com.example.model.dto.article.ArticleDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class SearchViewState(
    val articles: Flow<PagingData<ArticleDto>> = emptyFlow(),
)

sealed class SearchEvent {
    data class LoadArticles(val query: String) : SearchEvent()
    object NavigateToDetailsScreen : SearchEvent()
    object RefreshScreen : SearchEvent()

}