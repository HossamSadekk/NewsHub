package com.example.feed.ui.view.everythingComponent

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.feed.ui.FeedViewState

@Composable
fun ArticleItems(viewState: FeedViewState) {
    val articles = viewState.articles.collectAsLazyPagingItems()
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        items(articles.itemCount) {
            articles[it]?.let { article ->
                ArticleRow(articleDto = article, onDetailClick = {

                })
            }
        }
    }
}