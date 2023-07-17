package com.example.database.dao

import androidx.room.*
import com.example.model.local.article.ArticleEntity

@Dao
interface ArticleFavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(articleEntity: ArticleEntity)

    @Query("DELETE FROM articles WHERE title = :title")
    suspend fun deleteFavorite(title: String)

    @Query("SELECT EXISTS(SELECT 1 FROM articles WHERE title = :title LIMIT 1)")
    suspend fun isArticleExists(title: String): Boolean
}