package com.example.favorites.ui

import com.HomeScreenDirections
import com.NavigationManager
import com.example.common.mvvm.BaseViewState
import com.example.common.mvvm.Mvvm
import com.example.favorites.domain.use_case.GetFavoriteArticles
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getFavoriteArticles: GetFavoriteArticles,
    private val navigationManager: NavigationManager
) :
    Mvvm<FavoriteEvent>() {

    private val _uiState = MutableStateFlow<BaseViewState>(BaseViewState.Loading)
    val uiState: StateFlow<BaseViewState> = _uiState

    private val _uiStateFavorite = MutableStateFlow(FavoriteViewState())
    val uiStateFavorite: StateFlow<FavoriteViewState> = _uiStateFavorite

    init {
        loadArticles()
    }

    override fun onTriggerEvent(eventType: FavoriteEvent) {
        when (eventType) {
            is FavoriteEvent.LoadArticles -> {
                loadArticles()
            }
            is FavoriteEvent.NavigateToDetailsScreen -> {
                navigateToDetails()
            }
            is FavoriteEvent.RefreshScreen -> {
                refreshScreen()
            }
            else -> {}
        }
    }

    private fun refreshScreen() {
        loadArticles()
    }

    private fun loadArticles() = safeLaunch {
        call(getFavoriteArticles()) { articles ->
            if (articles.isEmpty()) {
                _uiState.value = BaseViewState.Empty
            } else {
                _uiState.value = BaseViewState.Data
                _uiStateFavorite.update {
                    it.copy(articles = articles)
                }
            }
        }
    }

    private fun navigateToDetails() {
        val command = HomeScreenDirections.detailsScreen()
        navigationManager.navigate(command)
    }

    override fun handleError(exception: Throwable) {
        Timber.e("exception in view_model :: $exception")
        _uiState.value = BaseViewState.Error(exception)
    }

    override fun startLoading() {
        _uiState.value = BaseViewState.Loading
    }


}