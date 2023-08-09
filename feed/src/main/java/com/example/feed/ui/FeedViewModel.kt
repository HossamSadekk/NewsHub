package com.example.feed.ui

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.HomeScreenDirections
import com.NavigationCommand
import com.NavigationManager
import com.example.common.mvvm.BaseViewState
import com.example.common.mvvm.Mvvm
import com.example.feed.domain.use_case.GetArticlesUseCase
import com.example.feed.domain.use_case.GetSourcesUseCase
import com.example.feed.domain.use_case.GetTopHeadlinesUseCase
import com.example.feed.ui.view.LoadingTopheadlines
import com.example.model.dto.article.ArticleDto
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val getTopHeadlinesUseCase: GetTopHeadlinesUseCase,
    private val getSourcesUseCase: GetSourcesUseCase,
    private val getArticlesUseCase: GetArticlesUseCase,
    private val navigationManager: NavigationManager
    ) :
    Mvvm<FeedEvent>() {
    private val _uiState = MutableStateFlow<BaseViewState>(BaseViewState.Loading)
    val uiState: StateFlow<BaseViewState> = _uiState

    private val _uiStateFeed = MutableStateFlow<FeedViewState>(FeedViewState())
    val uiStateFeed: StateFlow<FeedViewState> = _uiStateFeed

    private val _categoriesState = mutableStateOf(FeedViewState().categoriesList)
    val categoriesState: State<List<String>> = _categoriesState

    private val _selectedCategory = mutableStateOf("All")
    val selectedCategory: State<String> = _selectedCategory
    fun setCategory(value: String) {
        _selectedCategory.value = value
    }


    init {
        startLoading()
        loadTopHeadlines()
        loadSources()
        loadArticles()
    }

    override fun onTriggerEvent(eventType: FeedEvent) {
        when (eventType) {
            is FeedEvent.LoadTopHeadlines -> {
                loadTopHeadlines()
            }

            is FeedEvent.LoadArticles -> {
                loadArticles()
            }

            is FeedEvent.LoadSourcesList -> {
                loadSources()
            }
            is FeedEvent.RefreshScreen -> {
                refreshScreen()
            }
            is FeedEvent.NavigateToDetailsScreen -> {
                navigateToDetails()
            }
            is FeedEvent.NavigateToSourceContent -> {
                navigateToSourceContent()
            }
            else -> {}
        }
    }

    private fun navigateToDetails(){
        val command = HomeScreenDirections.detailsScreen()
        navigationManager.navigate(command)
    }
    private fun navigateToSourceContent(){
        val command = HomeScreenDirections.sourceContentScreen
        navigationManager.navigate(command)
    }

    private fun loadTopHeadlines() = safeLaunch {
        val pagedTopHeadlines = getTopHeadlinesUseCase().cachedIn(viewModelScope)
        _uiState.value = BaseViewState.Data
        _uiStateFeed.update {
            it.copy(topHeadlines = pagedTopHeadlines)
        }
    }

    private fun loadArticles() = safeLaunch {
        val pagedArticles = getArticlesUseCase(selectedCategory.value).cachedIn(viewModelScope)
        _uiState.value = BaseViewState.Data
        _uiStateFeed.update {
            it.copy(articles = pagedArticles)
        }
    }

    private fun loadSources() = safeLaunch {
        execute(getSourcesUseCase()) { sourcesList ->
            _uiState.value = BaseViewState.Data
            _uiStateFeed.update {
                it.copy(sourcesList = sourcesList)
            }
        }
    }

    override fun handleError(exception: Throwable) {
        Timber.e("exception in viewmodel :: $exception")
        _uiState.value = BaseViewState.Error(exception)
    }

    override fun startLoading() {
        _uiState.value = BaseViewState.Loading
    }

    private fun refreshScreen() {
        loadTopHeadlines()
        loadSources()
        loadArticles()
    }


}

