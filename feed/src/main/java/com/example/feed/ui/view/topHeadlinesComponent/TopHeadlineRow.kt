package com.example.feed.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.model.dto.ArticleDto

@Composable
fun TopHeadlineRow(
    articleDto: ArticleDto,
    onDetailClick: () -> Unit = {},
    modifier: Modifier
) {
    Card(
        shape = RoundedCornerShape(18.dp),
        elevation = 15.dp,
        modifier = Modifier
            .height(250.dp)
            .padding(start = 7.dp, end = 7.dp)
    ) {
        Box(
            modifier = modifier
        ) {
            val painter = rememberImagePainter(
                data = articleDto.urlToImage,
                builder = {
                    crossfade(true)
                }
            )

            Image(
                painter = painter,
                contentDescription = "Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(modifier = Modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(colors = listOf(
                    Color.Transparent,
                    Color.Black
                )
                , startY = 300f
                ))

            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = if (articleDto.title.isEmpty()) "No Title" else articleDto.title,
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    }
}
