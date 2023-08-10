package com.example.search.ui

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.HomeScreenDirections
import com.NavigationManager
import com.example.common.mvvm.BaseViewState
import com.example.common.mvvm.Mvvm
import com.example.search.domain.use_case.GetArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val getArticlesUseCase: GetArticlesUseCase
) : Mvvm<SearchEvent>() {
    private val _uiState = MutableStateFlow<BaseViewState>(BaseViewState.Empty)
    val uiState: StateFlow<BaseViewState> = _uiState

    private val _uiStateSearch = MutableStateFlow<SearchViewState>(SearchViewState())
    val uiStateSearch: StateFlow<SearchViewState> = _uiStateSearch

    private val searchQuery = MutableStateFlow("")


    override fun onTriggerEvent(eventType: SearchEvent) {
        when (eventType) {
            is SearchEvent.LoadArticles -> {
                loadArticles(eventType.query)
            }
            is SearchEvent.NavigateToDetailsScreen -> {
                navigateToDetails()
            }
            is SearchEvent.RefreshScreen -> {
                refreshScreen()
            }
            else -> {}
        }
    }

    fun refreshScreen() {
        loadArticles(searchQuery.value)
    }

    override fun handleError(exception: Throwable) {
        Timber.e("exception in viewmodel :: $exception")
        _uiState.value = BaseViewState.Error(exception)
    }

    override fun startLoading() {
        _uiState.value = BaseViewState.Loading
    }

    private var queryJob: Job? = null

    private fun loadArticles(query: String) {
        searchQuery.value = query
        queryJob?.cancel()
        queryJob = viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            handleError(throwable)
        }) {
            delay(500L)
            if (query.trim().isEmpty()) {
                _uiState.value = BaseViewState.Empty
            } else {
                val pagedArticles = getArticlesUseCase(searchQuery.value).cachedIn(viewModelScope)
                _uiState.value = BaseViewState.Data
                _uiStateSearch.update {
                    it.copy(articles = pagedArticles)
                }
            }
        }
    }

    private fun navigateToDetails() {
        val command = HomeScreenDirections.detailsScreen()
        navigationManager.navigate(command)
    }
}