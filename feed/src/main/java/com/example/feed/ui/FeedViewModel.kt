package com.example.feed.ui

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.common.mvvm.Mvvm
import com.example.feed.domain.use_case.GetSourcesUseCase
import com.example.feed.domain.use_case.GetTopHeadlinesUseCase
import com.example.feed.ui.view.LoadingTopheadlines
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
    private val getSourcesUseCase: GetSourcesUseCase
) :
    Mvvm<FeedEvent>() {
    private val _uiState = MutableStateFlow<BaseViewState>(BaseViewState.Loading)
    val uiState: StateFlow<BaseViewState> = _uiState

    private val _uiStateFeed = MutableStateFlow<FeedViewState>(FeedViewState())
    val uiStateFeed: StateFlow<FeedViewState> = _uiStateFeed


    init {
        startLoading()
        loadTopHeadlines()
        loadSources()
    }

    override fun onTriggerEvent(eventType: FeedEvent) {
        when (eventType) {
            is FeedEvent.LoadTopHeadlines -> {
                loadTopHeadlines()
            }
            is FeedEvent.LoadSourcesList -> {
                loadSources()
            }
            is FeedEvent.RefreshScreen -> {
                refreshScreen()
            }
            else -> {}
        }
    }

    private fun loadTopHeadlines() = safeLaunch {
        val pagedTopHeadlines = getTopHeadlinesUseCase().cachedIn(viewModelScope)
        _uiState.value = BaseViewState.Data
        _uiStateFeed.update {
            it.copy(topHeadlines = pagedTopHeadlines)
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

    fun refreshScreen(){
        loadTopHeadlines()
        loadSources()
    }


}

sealed class BaseViewState {
    object Loading : BaseViewState()
    object Empty : BaseViewState()
    object Data : BaseViewState()
    data class Error(val throwable: Throwable) : BaseViewState()
}