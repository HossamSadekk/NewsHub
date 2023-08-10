package com.example.search.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.common.mvvm.BaseViewState
import com.example.common.mvvm.SharedViewModel
import com.example.common.widget.LottieErrorView
import com.example.common.widget.ProgressIndicator
import com.example.search.ui.component.SearchContent
import com.example.search.ui.component.SearchTopAppBar
import timber.log.Timber

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    val uiStateSearch = viewModel.uiStateSearch.collectAsStateWithLifecycle()
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            SearchTopAppBar(viewModel)
        }
    ) {
        Box(modifier = Modifier.padding(paddingValues = it).fillMaxSize()) {
            when (uiState.value) {
                is BaseViewState.Data -> {
                    SearchContent(uiStateSearch.value, viewModel, sharedViewModel)
                }
                is BaseViewState.Empty -> {}
                is BaseViewState.Error -> {
                    Timber.e((uiState.value as BaseViewState.Error).throwable.toString())
                    LottieErrorView(
                        action = {
                            viewModel.onTriggerEvent(SearchEvent.RefreshScreen)
                        },
                        errorMessage = (uiState.value as BaseViewState.Error).throwable.message.toString()
                    )
                }
                is BaseViewState.Loading -> {
                    ProgressIndicator()
                }
            }
        }

    }
}