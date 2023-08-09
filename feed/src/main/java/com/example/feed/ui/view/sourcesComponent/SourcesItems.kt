package com.example.feed.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.common.mvvm.SharedViewModel
import com.example.feed.ui.FeedEvent
import com.example.feed.ui.FeedViewModel
import com.example.feed.ui.FeedViewState
import timber.log.Timber

@Composable
fun SourcesItems(viewState: FeedViewState,sharedViewModel: SharedViewModel,feedViewModel:FeedViewModel) {
    val sources = viewState.sourcesList
    LazyRow(
        modifier = Modifier.fillMaxWidth().padding(start = 7.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
    ){
        Timber.e(sources.size.toString())
        items(sources.size){
            sources[it]?.let {
                SourcesRow(it, onDetailClick = {
                    sharedViewModel.addSource(it)
                    feedViewModel.onTriggerEvent(FeedEvent.NavigateToSourceContent)
                })
            }
        }
    }
}