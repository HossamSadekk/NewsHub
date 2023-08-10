package com.example.source_content.ui

import androidx.paging.PagingData
import com.example.model.dto.article.ArticleDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class SourceViewState(
    val articles: Flow<PagingData<ArticleDto>> = emptyFlow(),
)
sealed class SourceContentEvent {
    object popUp : SourceContentEvent()
    data class LoadArticlesBySource(val sourceId: String) : SourceContentEvent()
    object NavigateToDetailsScreen : SourceContentEvent()

    object RefreshScreen : SourceContentEvent()

}