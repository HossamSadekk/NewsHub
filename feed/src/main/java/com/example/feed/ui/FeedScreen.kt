package com.example.feed.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.common.mvvm.BaseViewState
import com.example.common.mvvm.SharedViewModel
import com.example.common.widget.LottieErrorView
import com.example.common.widget.ProgressIndicator
import com.example.feed.ui.view.FeedContent
import timber.log.Timber

@Composable
fun FeedScreen(
    viewModel: FeedViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    val uiStateFeed = viewModel.uiStateFeed.collectAsStateWithLifecycle()

    when (uiState.value) {
        is BaseViewState.Data -> {
            FeedContent(uiStateFeed.value, viewModel, sharedViewModel)
        }
        is BaseViewState.Empty -> {}
        is BaseViewState.Error -> {
            Timber.e((uiState.value as BaseViewState.Error).throwable.toString())
            LottieErrorView(action = {
                viewModel.onTriggerEvent(FeedEvent.RefreshScreen)
            }, errorMessage = (uiState.value as BaseViewState.Error).throwable.message.toString())
        }
        is BaseViewState.Loading -> {
            ProgressIndicator()
        }
    }
}
