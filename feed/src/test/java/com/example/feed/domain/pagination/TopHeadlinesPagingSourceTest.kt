package com.example.feed.domain.pagination

import androidx.paging.PagingSource
import com.example.feed.data.repository.FeedRepositoryImpl
import com.example.model.dto.toArticleDtoList
import com.example.model.remote.articles.Article
import com.example.model.remote.articles.ArticlesResponse
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


class TopHeadlinesPagingSourceTest {
    @RelaxedMockK
    private lateinit var feedRepository: FeedRepositoryImpl

    private lateinit var pagingSource: TopHeadlinesPagingSource

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        pagingSource = TopHeadlinesPagingSource(feedRepository)
    }
    @Test
    fun testLoadSuccess() = runTest {
        // Given
        val pageSize = 10
        val position = 1
        val response = ArticlesResponse(
            totalResults = 36, status = "ok", articles = listOf(
                Article("","","","",null,"","",""),
                Article("","","","",null,"","",""),
                Article("","","","",null,"","","")
            )
        )
        coEvery {feedRepository.getTopHeadlines("us", pageSize, position)} returns (response)

        // When
        val result = pagingSource.load(
            PagingSource.LoadParams.Refresh(
                key = null,
                loadSize = pageSize,
                placeholdersEnabled = false
            )
        )

        // Then
        assertTrue(result is PagingSource.LoadResult.Page)
    }

    @Test
    fun testLoadError() = runTest {
        // Given
        val pageSize = 10
        val position = 1
        val exception = IOException()
        coEvery {feedRepository.getTopHeadlines("us", pageSize, position)} throws exception

        // When
        val result = pagingSource.load(
            PagingSource.LoadParams.Refresh(
                key = null,
                loadSize = pageSize,
                placeholdersEnabled = false
            )
        )

        // Then
        assertTrue(result is PagingSource.LoadResult.Error)
    }
}


