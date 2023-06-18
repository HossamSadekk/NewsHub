package com.example.feed.domain.pagination

import com.example.common.pagination.BasePagingSource
import com.example.feed.domain.repository.FeedRepository
import com.example.model.dto.article.ArticleDto
import com.example.model.dto.toArticleDtoList
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

class TopHeadlinesPagingSource @Inject constructor(private val feedRepository: FeedRepository) :
    BasePagingSource<ArticleDto>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticleDto> {
        /** the position indicate to the number of page that we are need,but at the first time it will be null **/
        val position = params.key ?: 1
        return try {
            val response = feedRepository.getTopHeadlines(
                country = "us",
                pageSize = params.loadSize,
                page = position
            )
            Timber.d(response.articles.size.toString())

            val articles = response.articles.toArticleDtoList()

            LoadResult.Page(
                data = articles,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (articles.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            Timber.d(exception.toString())
            // IOException for network failures.
            return LoadResult.Error(exception)
        }
    }
}

