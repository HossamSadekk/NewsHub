package com.example.feed.domain.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.feed.domain.repository.FeedRepository
import com.example.model.dto.ArticleDto
import com.example.model.dto.toArticleDtoList
import java.io.IOException
import javax.inject.Inject

class TopHeadlinesPagingSource @Inject constructor(private val feedRepository: FeedRepository) :
    PagingSource<Int, ArticleDto>() {

    /***
     * The getRefreshKey function is responsible for determining a key that can be used to load the latest data from the server.
     * The key should be based on the current state of the PagingSource
     ***/
    override fun getRefreshKey(state: PagingState<Int, ArticleDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticleDto> {
        /** the position indicate to the number of page that we are need,but at the first time it will be null **/
        val position = params.key ?: 1
        return try {
            val response = feedRepository.getTopHeadlines(
                country = "us",
                pageSize = params.loadSize,
                page = position
            )
            val articles = response.articles.toArticleDtoList()

            LoadResult.Page(
                data = articles,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (articles.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            // IOException for network failures.
            return LoadResult.Error(exception)
        }
    }
}

