package com.example.model.dto

import com.example.model.remote.Article

fun Article.toArticleDto(): ArticleDto = ArticleDto(
    title = title,
    description = description,
    publishedAt = publishedAt,
    source = source.name,
    urlToImage = urlToImage
)

fun List<Article>.toArticleDtoList(): List<ArticleDto> = map { it.toArticleDto() }