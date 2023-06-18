package com.example.model.remote.articles


import com.google.gson.annotations.SerializedName

data class ArticlesResponse(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)