package com.example.feed.domain.repository

import com.example.model.remote.articles.ArticlesResponse
import com.example.model.remote.sources.SourcesResponse

interface FeedRepository {
    suspend fun getTopHeadlines(country: String, pageSize: Int, page: Int): ArticlesResponse
    suspend fun getArticles(query: String): ArticlesResponse

    suspend fun getSources(): SourcesResponse

}