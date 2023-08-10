package com.example.source_content.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.common.mvvm.BaseViewState
import com.example.common.mvvm.SharedViewModel
import com.example.common.widget.LottieErrorView
import com.example.common.widget.ProgressIndicator
import com.example.source_content.ui.views.SourceContent
import timber.log.Timber

@Composable
fun SourceContentScreen(
    sharedViewModel: SharedViewModel,
    viewModel: SourceContentViewModel = hiltViewModel()
) {
    val source = sharedViewModel.source.value
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    val uiStateSource = viewModel.uiStateSource.collectAsStateWithLifecycle()
    viewModel.setSourceId(source?.id ?: "")
    LaunchedEffect(viewModel.sourceId) {
        viewModel.onTriggerEvent(SourceContentEvent.LoadArticlesBySource(viewModel.sourceId.value))
    }
    when (uiState.value) {
        is BaseViewState.Data -> {
            SourceContent(viewModel, uiStateSource.value, sharedViewModel)
        }
        is BaseViewState.Empty -> {}
        is BaseViewState.Error -> {
            Timber.e((uiState.value as BaseViewState.Error).throwable.toString())
            LottieErrorView(action = {
                viewModel.onTriggerEvent(SourceContentEvent.RefreshScreen)
            }, errorMessage = (uiState.value as BaseViewState.Error).throwable.message.toString())
        }
        is BaseViewState.Loading -> {
            ProgressIndicator()
        }
    }
}