package com.example.article_details.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.article_details.R
import com.example.article_details.ui.ArticleDetailsViewModel

@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    viewModel: ArticleDetailsViewModel,
    onFavClicked: () -> Unit
) {
    val viewState = viewModel.isFavoriteState
    var isFavorite = rememberSaveable(viewState.value) { viewState.value }

    IconButton(
        onClick = {
            viewModel.setState(!isFavorite)
            onFavClicked()
        },
        modifier = modifier.size(50.dp).padding(end = 10.dp, top = 20.dp)
    ) {
        Icon(
            painter = if (isFavorite) {
                painterResource(id = R.drawable.baseline_favorite_24 )
            } else {
                painterResource(id = R.drawable.baseline_favorite_border)
            },
            contentDescription = null,
            modifier = Modifier.size(32.dp),
            tint = MaterialTheme.colors.primaryVariant
        )
    }
}