package com.example.favorites.domain.use_case

import com.example.common.use_case.LocalUseCase
import com.example.favorites.domain.repository.FavoriteRepository
import com.example.model.dto.article.ArticleDto
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class GetFavoriteArticles @Inject constructor(private val repository: FavoriteRepository) :
    LocalUseCase<List<ArticleDto>>() {
    override suspend fun FlowCollector<List<ArticleDto>>.execute() {
        val favorite = repository.getAllFavorites()
        emit(favorite)
    }
}