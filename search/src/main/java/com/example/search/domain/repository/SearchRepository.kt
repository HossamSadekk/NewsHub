package com.example.search.domain.repository

import com.example.model.remote.articles.ArticlesResponse

interface SearchRepository {
    suspend fun getArticles(query: String): ArticlesResponse
}