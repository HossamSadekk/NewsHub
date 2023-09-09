package com.example.article_details.data.repository

import com.example.database.dao.ArticleFavoriteDao
import com.example.model.local.article.ArticleEntity
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class ArticleDetailsRepoImplTest {

    private lateinit var repo: ArticleDetailsRepoImpl
    private val dao: ArticleFavoriteDao = mockk()

    @Before
    fun setup() {
        repo = ArticleDetailsRepoImpl(dao)
    }

    @Test
    fun `isArticleExist should return true when article exists`() = runBlocking {
        // Arrange
        val articleTitle = "Sample Article"
        coEvery { dao.isArticleExists(articleTitle) } returns true

        // Act
        val result = repo.isArticleExist(articleTitle)

        // Assert
        assert(result)
    }

    @Test
    fun `isArticleExist should return false when article does not exist`() = runBlocking {
        // Arrange
        val articleTitle = "Non-Existent Article"
        coEvery { dao.isArticleExists(articleTitle) } returns false

        // Act
        val result = repo.isArticleExist(articleTitle)

        // Assert
        assert(!result)
    }

    @Test
    fun `addArticle should insert the article into the database`() = runBlocking {
        // Arrange
        val articleEntity = ArticleEntity("", "", "", "", "", "", "")
        coEvery { dao.insertArticle(articleEntity) } returns Unit

        // Act
        repo.addArticle(articleEntity)

        // Assert
        // Verify that the insertArticle method was called with the correct entity
        coVerify { dao.insertArticle(articleEntity) }
    }

    @Test
    fun `deleteFavorite should delete the favorite article from the database`() = runBlocking {
        // Arrange
        val articleTitle = "Favorite Article"
        coEvery { dao.deleteFavorite(articleTitle) } returns Unit

        // Act
        repo.deleteFavorite(articleTitle)

        // Assert
        // Verify that the deleteFavorite method was called with the correct article title
        coVerify { dao.deleteFavorite(articleTitle) }
    }


}