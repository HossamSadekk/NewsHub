package com.example.source_content.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.common.mvvm.SharedViewModel
import com.example.common.widget.ShimmerItem
import com.example.common.widget.popUpButton
import com.example.feed.ui.view.everythingComponent.ArticleRow
import com.example.model.dto.article.ArticleDto
import com.example.model.dto.toArticleEntity
import com.example.source_content.ui.SourceContentEvent
import com.example.source_content.ui.SourceContentViewModel
import com.example.source_content.ui.SourceViewState
import timber.log.Timber

@Composable
fun SourceContent(viewModel: SourceContentViewModel,viewState: SourceViewState,sharedViewModel:SharedViewModel) {
    val scrollState = rememberLazyListState()


    Box(Modifier.fillMaxSize().background(MaterialTheme.colors.background)) {
        val articles = viewState.articles.collectAsLazyPagingItems()
        Timber.d(articles.toString()+" !!! !!!")
        LazyColumn(state = scrollState, contentPadding = PaddingValues(bottom = 90.dp)) {
            item{
                Row(
                    modifier = Modifier.fillMaxWidth().padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // pop up button
                    popUpButton(popUp = {
                        // when button is clicked
                        viewModel.onTriggerEvent(SourceContentEvent.popUp)
                    })
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = sharedViewModel.source.value?.name+" Content",
                        maxLines = 1,
                        modifier = Modifier.padding(top = 15.dp),
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.caption,
                        color = MaterialTheme.colors.secondaryVariant
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
            }
            when (articles.loadState.refresh) {
                is LoadState.Loading -> {
                    items(50) {
                        ShimmerItem()
                    }
                }
                else -> {
                    items(articles.itemCount) {
                        articles[it]?.let { article ->
                            ArticleRow(articleDto = article, onDetailClick = {
                                sharedViewModel.addArticle(article)
                                viewModel.onTriggerEvent(SourceContentEvent.NavigateToDetailsScreen)
                            })
                        }
                    }
                }
            }
        }
    }
}