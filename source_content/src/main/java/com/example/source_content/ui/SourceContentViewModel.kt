package com.example.source_content.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.HomeScreenDirections
import com.NavigationManager
import com.example.common.mvvm.BaseViewState
import com.example.common.mvvm.Mvvm
import com.example.source_content.domain.use_case.GetArticlesBySourceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SourceContentViewModel @Inject constructor
    (
    private val getArticlesBySourceUseCase: GetArticlesBySourceUseCase,
    private val navigationManager: NavigationManager
) :
    Mvvm<SourceContentEvent>() {
    private val _uiState = MutableStateFlow<BaseViewState>(BaseViewState.Loading)
    val uiState: StateFlow<BaseViewState> = _uiState

    private val _uiStateSource = MutableStateFlow<SourceViewState>(SourceViewState())
    val uiStateSource: StateFlow<SourceViewState> = _uiStateSource

    private val _sourceId = mutableStateOf("")
    val sourceId: State<String> = _sourceId
    fun setSourceId(value: String) {
        _sourceId.value = value
    }


    override fun onTriggerEvent(eventType: SourceContentEvent) {
        when (eventType) {
            is SourceContentEvent.LoadArticlesBySource -> {
                loadArticlesBySource(eventType.sourceId)
            }
            is SourceContentEvent.popUp -> {
                navigateBack()
            }
            is SourceContentEvent.NavigateToDetailsScreen -> {
                navigateToDetails()
            }
            else -> {}
        }
    }

    private fun navigateBack() {
        navigationManager.navigateBack()
    }

    private fun navigateToDetails() {
        val command = HomeScreenDirections.detailsScreen()
        navigationManager.navigate(command)
    }

    private fun loadArticlesBySource(sourceId: String) = safeLaunch {
        val pagedArticles = getArticlesBySourceUseCase(sourceId).cachedIn(viewModelScope)
        _uiState.value = BaseViewState.Data
        _uiStateSource.update {
            it.copy(articles = pagedArticles)
        }
    }

    override fun handleError(exception: Throwable) {
        Timber.e("exception in viewmodel :: $exception")
        _uiState.value = BaseViewState.Error(exception)
    }

    override fun startLoading() {
        _uiState.value = BaseViewState.Loading
    }
}