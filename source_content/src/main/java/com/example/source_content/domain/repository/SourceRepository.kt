package com.example.source_content.domain.repository

import com.example.model.remote.articles.ArticlesResponse

interface SourceRepository {
    suspend fun getArticlesBySource(sourceId: String): ArticlesResponse
}