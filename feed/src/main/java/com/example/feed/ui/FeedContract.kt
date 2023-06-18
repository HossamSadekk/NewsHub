package com.example.feed.ui

import androidx.paging.PagingData
import com.example.model.dto.article.ArticleDto
import com.example.model.dto.sources.SourceDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow


data class FeedViewState(
    val topHeadlines: Flow<PagingData<ArticleDto>> = emptyFlow(),
    val sourcesList: List<SourceDto> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)

sealed class FeedEvent {
    object LoadTopHeadlines : FeedEvent()
    object LoadSourcesList : FeedEvent()
    object RefreshScreen : FeedEvent()
}
