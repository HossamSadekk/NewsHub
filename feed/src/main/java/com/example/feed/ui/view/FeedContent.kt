package com.example.feed.ui.view

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
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
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.common.mvvm.SharedViewModel
import com.example.common.widget.GoUp
import com.example.common.widget.ShimmerItem
import com.example.feed.ui.FeedEvent
import com.example.feed.ui.FeedViewModel
import com.example.feed.ui.FeedViewState
import com.example.feed.ui.view.everythingComponent.ArticleItems
import com.example.feed.ui.view.everythingComponent.ArticleRow
import com.example.feed.ui.view.everythingComponent.Categories
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@Composable
fun FeedContent(viewState: FeedViewState, feedViewModel: FeedViewModel,sharedViewModel: SharedViewModel) {
    val scrollState = rememberLazyListState()
    val scope = rememberCoroutineScope()
    val showButton = remember {
        derivedStateOf {
            scrollState.firstVisibleItemIndex > 0
        }
    }
    Box(Modifier.fillMaxSize()) {
        val articles = viewState.articles.collectAsLazyPagingItems()



        LazyColumn(state = scrollState, contentPadding = PaddingValues(bottom = 90.dp)) {
            item {
                CategoryTitle("Top Headlines", topPadding = 20.dp, bottomPadding = 20.dp)
                TopHeadlinesItems(
                    viewState, modifier = Modifier
                        .height(140.dp)
                        .fillMaxWidth(), feedViewModel, sharedViewModel
                )
            }
            // displaying the sources section.
            item {
                CategoryTitle("Sources", topPadding = 20.dp, bottomPadding = 20.dp)
                SourcesItems(viewState)
            }
            // the everything section ( categories )
            item {
                CategoryTitle("Everything", topPadding = 20.dp, bottomPadding = 20.dp)
                Categories(categories = feedViewModel.categoriesState.value,
                    selectedCategory = feedViewModel.selectedCategory.value,
                    onSelectCategory = { category ->
                        feedViewModel.setCategory(category)
                        feedViewModel.onTriggerEvent(FeedEvent.LoadArticles)
                    })
                Spacer(modifier = Modifier.height(20.dp))
            }
            // displaying the everything section.
            when (articles.loadState.refresh) {
                is LoadState.Loading -> {
                    items(20) {
                        ShimmerItem()
                    }
                }
                else -> {
                    items(articles.itemCount) {
                        articles[it]?.let { article ->
                            ArticleRow(articleDto = article, onDetailClick = {
                                sharedViewModel.addArticle(article)
                                feedViewModel.onTriggerEvent(FeedEvent.NavigateToDetailsScreen)
                            })
                        }
                    }
                }
            }


        }
    }
    AnimatedVisibility(visible = showButton.value, enter = fadeIn(), exit = fadeOut()) {
        GoUp {
            scope.launch {
                scrollState.scrollToItem(0)
            }
        }
    }
}

