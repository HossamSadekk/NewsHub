package com.example.search.data.repository

import com.example.model.remote.articles.ArticlesResponse
import com.example.remote.service.NewsApi
import com.example.search.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(private val newsService: NewsApi) :
    SearchRepository {
    override suspend fun getArticles(query: String): ArticlesResponse =
        newsService.getArticles(query)
}