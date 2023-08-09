package com.example.source_content.data.repository

import com.example.model.remote.articles.ArticlesResponse
import com.example.remote.service.NewsApi
import com.example.source_content.domain.repository.SourceRepository
import javax.inject.Inject

class SourceRepositoryImpl @Inject constructor(private val newsApi: NewsApi):SourceRepository {
    override suspend fun getArticlesBySource(sourceId: String): ArticlesResponse = newsApi.getArticlesBySource(sourceId)
}