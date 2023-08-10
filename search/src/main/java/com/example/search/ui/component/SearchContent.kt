package com.example.search.ui.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.common.mvvm.SharedViewModel
import com.example.common.widget.ShimmerItem
import com.example.feed.ui.view.everythingComponent.ArticleRow
import com.example.search.ui.SearchEvent
import com.example.search.ui.SearchViewModel
import com.example.search.ui.SearchViewState

@Composable
fun SearchContent(
    viewState: SearchViewState,
    searchViewModel: SearchViewModel,
    sharedViewModel: SharedViewModel,
) {
    val articles = viewState.articles.collectAsLazyPagingItems()
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        when (articles.loadState.refresh) {
            is LoadState.Loading -> {
                items(20) {
                    ShimmerItem()
                }
            }
            is LoadState.Error -> {
                val errorState = articles.loadState.refresh as LoadState.Error
                val throwable: Throwable = errorState.error
                searchViewModel.handleError(throwable)
            }
            else -> {
                items(articles.itemCount) {
                    articles[it]?.let { article ->
                        ArticleRow(articleDto = article, onDetailClick = {
                            sharedViewModel.addArticle(article)
                            searchViewModel.onTriggerEvent(SearchEvent.NavigateToDetailsScreen)
                        })
                    }
                }
            }
        }
    }
}