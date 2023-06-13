package com.example.feed.domain.repository

import com.example.model.dto.ArticleDto
import com.example.model.remote.ArticlesResponse

interface FeedRepository {
    suspend fun getTopHeadlines(country: String, pageSize: Int, page: Int): ArticlesResponse
}