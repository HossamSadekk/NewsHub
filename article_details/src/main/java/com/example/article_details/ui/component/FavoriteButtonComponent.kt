package com.example.article_details.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.article_details.R

@Composable
fun FavoriteButton(modifier: Modifier = Modifier, onFavClicked: () -> Unit) {
    IconButton(
        onClick = {
            onFavClicked
        },
        modifier = modifier.size(50.dp).padding(end = 10.dp, top = 20.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_favorite_border),
            contentDescription = null,
            modifier = Modifier.size(32.dp),
            tint = MaterialTheme.colors.primaryVariant
        )
    }
}