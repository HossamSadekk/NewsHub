package com.example.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.database.dao.ArticleFavoriteDao
import com.example.model.local.article.ArticleEntity

@Database(
    entities = [ArticleEntity::class],
    version = 1
)
abstract class NewsHubDatabase : RoomDatabase() {
    abstract fun articleFavoriteDao(): ArticleFavoriteDao
}