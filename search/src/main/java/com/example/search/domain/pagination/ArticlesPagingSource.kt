package com.example.search.domain.pagination

import com.example.common.pagination.BasePagingSource
import com.example.model.dto.article.ArticleDto
import com.example.model.dto.toArticleDtoList
import com.example.search.domain.repository.SearchRepository
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

class ArticlesPagingSource @Inject constructor(
    private val repository: SearchRepository,
    private val query: String
) :
    BasePagingSource<ArticleDto>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticleDto> {
        /** the position indicate to the number of page that we are need,but at the first time it will be null **/
        val position = params.key ?: 1
        return try {
            val response = repository.getArticles(query)
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