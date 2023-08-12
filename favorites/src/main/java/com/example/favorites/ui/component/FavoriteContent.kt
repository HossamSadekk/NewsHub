package com.example.favorites.ui.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.common.mvvm.SharedViewModel
import com.example.favorites.ui.FavoriteEvent
import com.example.favorites.ui.FavoriteViewModel
import com.example.favorites.ui.FavoriteViewState
import com.example.feed.ui.view.everythingComponent.ArticleRow

@Composable
fun FavoriteContent(
    viewState: FavoriteViewState,
    favoriteViewModel: FavoriteViewModel,
    sharedViewModel: SharedViewModel,
) {
    val articles = viewState.articles
    LazyColumn(modifier = Modifier.fillMaxSize().padding(bottom = 56.dp)) {
        items(articles.size) {
            articles[it]?.let { article ->
                ArticleRow(articleDto = article, onDetailClick = {
                    sharedViewModel.addArticle(article)
                    favoriteViewModel.onTriggerEvent(FavoriteEvent.NavigateToDetailsScreen)
                })
            }
        }
    }
}