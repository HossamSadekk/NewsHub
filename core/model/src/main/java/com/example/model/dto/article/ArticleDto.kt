package com.example.model.dto.article


data class ArticleDto(
    val title: String,
    val description: String,
    val content: String,
    val publishedAt: String,
    val source: String,
    val urlToImage: String
)
