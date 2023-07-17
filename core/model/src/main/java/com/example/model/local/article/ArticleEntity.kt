package com.example.model.local.article
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class ArticleEntity(
    @PrimaryKey
    val title: String,
    val description: String,
    val content: String,
    val publishedAt: String,
    val source: String,
    val urlToImage: String,
    val urlWebsite: String
)