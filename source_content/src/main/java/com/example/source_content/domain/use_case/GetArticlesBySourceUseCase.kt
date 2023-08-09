package com.example.source_content.domain.use_case

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.common.use_case.FlowPagingUseCase
import com.example.model.dto.article.ArticleDto
import com.example.source_content.domain.pagination.SourcePagingSource
import com.example.source_content.domain.repository.SourceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetArticlesBySourceUseCase @Inject constructor(
    private val repository: SourceRepository,
) :
    FlowPagingUseCase<ArticleDto>() {
    override fun execute(parameter: String?): Flow<PagingData<ArticleDto>> =
        Pager(
            config = PagingConfig(
                pageSize = 20 // how many items per request, this value that will be passed into "params.loadSize" when we make our request.
            ),
            pagingSourceFactory = { SourcePagingSource(repository, parameter ?: "") }
        ).flow
}