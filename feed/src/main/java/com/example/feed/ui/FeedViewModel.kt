package com.example.feed.ui

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.common.mvvm.Mvvm
import com.example.feed.domain.use_case.GetTopHeadlinesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
@HiltViewModel
class FeedViewModel @Inject constructor(private val getTopHeadlinesUseCase: GetTopHeadlinesUseCase) :
    Mvvm<FeedEvent>() {
    private val _uiState = MutableStateFlow<BaseViewState>(BaseViewState.Loading)
    val uiState: StateFlow<BaseViewState> = _uiState

    override fun onTriggerEvent(eventType: FeedEvent) {
        when (eventType) {
            is FeedEvent.LoadTopHeadlines -> {
                loadTopHeadlines()
            }
        }
    }

    private fun loadTopHeadlines() = safeLaunch {
        startLoading()
        val pagedTopHeadlines = getTopHeadlinesUseCase().cachedIn(viewModelScope)
        _uiState.value = BaseViewState.Data(FeedViewState(topHeadlines = pagedTopHeadlines))
    }

    override fun handleError(exception: Throwable) {
        _uiState.value = BaseViewState.Data(FeedViewState(error = exception.message.toString()))
    }

    override fun startLoading() {
        _uiState.value = BaseViewState.Loading
    }


}
sealed class BaseViewState {
    object Loading : BaseViewState()
    object Empty : BaseViewState()
    data class Data(val value: FeedViewState) : BaseViewState()
    data class Error(val throwable: Throwable) : BaseViewState()
}