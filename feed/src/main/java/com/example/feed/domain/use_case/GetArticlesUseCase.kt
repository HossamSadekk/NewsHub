package com.example.feed.domain.use_case

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.common.use_case.FlowPagingUseCase
import com.example.feed.domain.pagination.ArticlesPagingSource
import com.example.feed.domain.pagination.TopHeadlinesPagingSource
import com.example.feed.domain.repository.FeedRepository
import com.example.model.dto.article.ArticleDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(
    private val repository: FeedRepository,
) :
    FlowPagingUseCase<ArticleDto>() {
    override fun execute(parameter: String?): Flow<PagingData<ArticleDto>> =
        Pager(
            config = PagingConfig(
                pageSize = 20 // how many items per request, this value that will be passed into "params.loadSize" when we make our request.
            ),
            pagingSourceFactory = { ArticlesPagingSource(repository, parameter ?: "All") }
        ).flow
}