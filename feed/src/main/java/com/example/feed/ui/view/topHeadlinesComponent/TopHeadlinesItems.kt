package com.example.feed.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.network.HttpException
import com.example.common.mvvm.SharedViewModel
import com.example.feed.ui.FeedEvent
import com.example.feed.ui.FeedViewModel
import com.example.feed.ui.FeedViewState
import timber.log.Timber
import java.io.IOException

@Composable
fun TopHeadlinesItems(viewState: FeedViewState, modifier: Modifier, viewModel: FeedViewModel,sharedViewModel: SharedViewModel) {
    val topHeadlines = viewState.topHeadlines.collectAsLazyPagingItems()
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp - 15.dp
    when (topHeadlines.loadState.refresh) {
        is LoadState.Loading -> {
            LoadingTopheadlines(Modifier.width(screenWidth))
        }
        is LoadState.Error -> {
            val error = topHeadlines.loadState.refresh as LoadState.Error
            val errorMessage = when (error.error) {
                is HttpException -> "Sorry, Something went wrong!\nTap to retry"
                is IOException -> "Connection failed. Tap to retry!"
                else -> "Failed! Tap to retry!"
            }
            ErrorLoadingTopheadlines(Modifier.width(screenWidth), error = errorMessage, refresh = {
                viewModel.onTriggerEvent(FeedEvent.LoadTopHeadlines)
            })
        }
        else -> {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(count = topHeadlines.itemCount) {
                    topHeadlines[it]?.let {
                        TopHeadlineRow(it,
                            modifier = modifier
                                .width(screenWidth),
                            onDetailClick = {
                                sharedViewModel.addArticle(it)
                                    viewModel.onTriggerEvent(FeedEvent.NavigateToDetailsScreen(it))
                            })
                    }
                }

            }

        }
    }

}
