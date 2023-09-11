package com.example.article_details.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.article_details.ui.component.*
import com.example.common.utils.DateUtils
import com.example.common.widget.popUpButton
import com.example.model.dto.article.ArticleDto
import com.example.model.dto.toArticleEntity

@SuppressLint("NewApi")
@Composable
fun DetailsContent(article: ArticleDto?,viewModel: ArticleDetailsViewModel) {
    viewModel.onTriggerEvent(ArticleDetailsEvent.checkArticleAvilability(article?.title ?: ""))
    Box(Modifier.fillMaxSize().background(MaterialTheme.colors.background)) {
        LazyColumn {
            item {
                Column(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight()
                        .background(color = MaterialTheme.colors.background),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // pop up button
                        popUpButton(popUp = {
                            // when button is clicked
                            viewModel.onTriggerEvent(ArticleDetailsEvent.popUp)
                        })

                        // favorite button
                        FavoriteButton(onFavClicked = {
                            viewModel.onTriggerEvent(ArticleDetailsEvent.updateArticleFavoriteState(article!!.toArticleEntity()))
                        }, viewModel = viewModel)
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = article?.title ?: "No Title",
                        style = MaterialTheme.typography.h2,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(7.dp))
                    Text(
                        text = article?.source
                                + " • " + article?.publishedAt?.let {
                            DateUtils.getTimeDifference(
                                it
                            )
                        },
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.subtitle1, color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    ImageCard(article?.urlToImage)
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        modifier = Modifier.fillMaxHeight().padding(start = 3.dp, end = 3.dp),
                        text = article?.description + article?.content,
                        style = MaterialTheme.typography.body1,
                        textAlign = TextAlign.Justify
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    ShowFullDetailsButton(article?.urlWebsite?:"")

                }
            }
        }
    }


}