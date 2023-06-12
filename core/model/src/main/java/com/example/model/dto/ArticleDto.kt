package com.example.model.dto

import com.example.model.remote.Source
import com.google.gson.annotations.SerializedName

data class ArticleDto(
    val title: String,
    val description: String,
    val publishedAt: String,
    val source: String,
    val urlToImage: String
)
