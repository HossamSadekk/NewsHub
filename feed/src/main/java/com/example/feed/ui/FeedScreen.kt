package com.example.feed.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.common.extension.cast
import com.example.common.widget.ProgressIndicator
import com.example.feed.ui.view.FeedContent

@Composable
fun FeedScreen(
    viewModel: FeedViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState.value) {
        is BaseViewState.Data -> {
            FeedContent((uiState.value as BaseViewState.Data).value,viewModel)
        }
        is BaseViewState.Empty -> {}
        is BaseViewState.Error -> {
            Log.d("ioio",(uiState.value as BaseViewState.Data).value.error)}
        is BaseViewState.Loading -> {
        }
    }

    LaunchedEffect(key1 = viewModel, block = {
        viewModel.onTriggerEvent(FeedEvent.LoadTopHeadlines)
    })

}
