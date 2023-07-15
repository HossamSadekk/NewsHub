package com.example.model.dto

import com.example.model.dto.article.ArticleDto
import com.example.model.remote.articles.Article

fun Article.toArticleDto(): ArticleDto = ArticleDto(
    title = title ?: "",
    content = content ?: "",
    description = description ?: "",
    publishedAt = publishedAt ?: "",
    source = source?.name ?: "",
    urlToImage = urlToImage ?: "",
    urlWebsite = url ?: "",
)

fun List<Article>.toArticleDtoList(): List<ArticleDto> = map { it.toArticleDto() }