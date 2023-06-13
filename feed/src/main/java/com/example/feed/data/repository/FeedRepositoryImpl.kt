package com.example.feed.data.repository

import com.example.feed.domain.repository.FeedRepository
import com.example.model.dto.ArticleDto
import com.example.model.remote.ArticlesResponse
import com.example.remote.service.NewsApi
import javax.inject.Inject

class FeedRepositoryImpl @Inject constructor(private val newsService: NewsApi) : FeedRepository {
    override suspend fun getTopHeadlines(
        country: String,
        pageSize: Int,
        page: Int
    ): ArticlesResponse = newsService.getTopHeadlines(country, pageSize, page)
}