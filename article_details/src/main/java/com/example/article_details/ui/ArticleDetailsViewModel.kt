package com.example.article_details.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.NavigationManager
import com.example.article_details.domain.use_case.GetIsArticleExistUseCase
import com.example.article_details.domain.use_case.UpdateFavoriteUseCase
import com.example.common.mvvm.Mvvm
import com.example.model.local.article.ArticleEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ArticleDetailsViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val getIsArticleExists: GetIsArticleExistUseCase,
    private val updateFavoriteUseCase: UpdateFavoriteUseCase
) :
    Mvvm<ArticleDetailsEvent>() {

    private val _isFavoriteState = mutableStateOf(false)
    val isFavoriteState: State<Boolean> = _isFavoriteState

    fun setState(value: Boolean) {
        _isFavoriteState.value = value
    }

    override fun onTriggerEvent(eventType: ArticleDetailsEvent) {
        when (eventType) {
            is ArticleDetailsEvent.popUp -> {
                navigateBack()
            }
            is ArticleDetailsEvent.checkArticleAvilability -> {
                checkArticleAvailability(eventType.article)
            }
            is ArticleDetailsEvent.updateArticleFavoriteState -> {
                updateArticleFavoriteState(eventType.article)
            }
            else -> {}
        }
    }

    private fun navigateBack() {
        navigationManager.navigateBack()
    }

    private fun checkArticleAvailability(article: String) = safeLaunch {
        val isFavorite = getIsArticleExists.invoke(article)
        _isFavoriteState.value = isFavorite
    }

    private fun updateArticleFavoriteState(articleEntity: ArticleEntity) = safeLaunch {
        updateFavoriteUseCase(articleEntity)
    }

    override fun handleError(exception: Throwable) {
    }

    override fun startLoading() {
    }

}