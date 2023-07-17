package com.example.feed.ui

import androidx.paging.PagingData
import com.example.model.dto.article.ArticleDto
import com.example.model.dto.sources.SourceDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow


data class FeedViewState(
    val topHeadlines: Flow<PagingData<ArticleDto>> = emptyFlow(),
    val articles: Flow<PagingData<ArticleDto>> = emptyFlow(),
    val sourcesList: List<SourceDto> = emptyList(),
    val categoriesList: List<String> = categories,
    val isLoading: Boolean = false,
    val error: String = ""
) {
    companion object {
        val categories = listOf(
            "All",
            "Sports",
            "Movies",
            "Technology",
            "Politics",
            "Entertainment",
            "Business",
            "Health",
            "Science",
            "Fashion",
            "Travel"
        )
    }
}

sealed class FeedEvent {
    object LoadTopHeadlines : FeedEvent()
    object LoadArticles : FeedEvent()
    object LoadSourcesList : FeedEvent()
    object RefreshScreen : FeedEvent()
    object NavigateToDetailsScreen : FeedEvent()
}
