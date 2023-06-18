package com.example.feed.ui

import android.util.Log
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.common.widget.LottieErrorView
import com.example.common.widget.ProgressIndicator
import com.example.feed.ui.view.FeedContent
import timber.log.Timber

@Composable
fun FeedScreen(
    viewModel: FeedViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    val uiStateFeed = viewModel.uiStateFeed.collectAsStateWithLifecycle()

    when (uiState.value) {
        is BaseViewState.Data -> {
            FeedContent(uiStateFeed.value, viewModel)
        }
        is BaseViewState.Empty -> {}
        is BaseViewState.Error -> {
            Timber.e((uiState.value as BaseViewState.Error).throwable.toString())
            LottieErrorView( action = {
                    viewModel.onTriggerEvent(FeedEvent.RefreshScreen)
            })
        }
        is BaseViewState.Loading -> {
            ProgressIndicator()
        }
    }
}
