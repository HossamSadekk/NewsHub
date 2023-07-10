package com.example.feed.data.repository

import com.example.feed.domain.repository.FeedRepository
import com.example.model.remote.articles.ArticlesResponse
import com.example.model.remote.sources.SourcesResponse
import com.example.remote.service.NewsApi
import javax.inject.Inject

class FeedRepositoryImpl @Inject constructor(private val newsService: NewsApi) : FeedRepository {
    override suspend fun getTopHeadlines(
        country: String,
        pageSize: Int,
        page: Int
    ): ArticlesResponse = newsService.getTopHeadlines(country, pageSize, page)

    override suspend fun getArticles(query: String): ArticlesResponse =
        newsService.getArticles(query)

    override suspend fun getSources(): SourcesResponse = newsService.getSources()

}