package com.example.feed.ui.view

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.feed.ui.FeedViewModel
import com.example.feed.ui.FeedViewState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first

@Composable
fun FeedContent(viewState: FeedViewState,feedViewModel: FeedViewModel) {
    Box(Modifier.fillMaxSize()) {
        val v = viewState.topHeadlines.collectAsLazyPagingItems()
        Log.d("ioio", ""+v.loadState.append.toString())
        val scrollState = rememberLazyListState()

        LazyColumn(state = scrollState, contentPadding = PaddingValues(bottom = 90.dp)) {
            item {
                CategoryTitle("Top Headlines", topPadding = 20.dp, bottomPadding = 20.dp)
                TopHeadlinesItems(
                    viewState, modifier = Modifier
                        .height(140.dp)
                        .fillMaxWidth(),feedViewModel
                )
            }

            item {
                CategoryTitle("Sources", topPadding = 20.dp, bottomPadding = 20.dp)

            }


        }}
    }

