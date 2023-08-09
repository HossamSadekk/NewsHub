package com.example.feed.ui.view.everythingComponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.common.utils.DateUtils
import com.example.common.R
import com.example.model.dto.article.ArticleDto

@Composable
fun ArticleRow(
    articleDto: ArticleDto,
    onDetailClick: () -> Unit = {},
) {
    Row(modifier = Modifier.fillMaxWidth().padding(10.dp).clickable {
        onDetailClick()
    }) {
        val painter = rememberImagePainter(
            data = articleDto.urlToImage,
            builder = {
                crossfade(true)
                error(R.drawable.placeholder)
            }
        )

        Image(
            painter = painter,
            contentDescription = "Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(120.dp)
                .width(120.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Spacer(modifier = Modifier.width(10.dp))

        Column(modifier = Modifier.fillMaxWidth().height(120.dp)) {
            Text(
                text = articleDto.title,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.secondaryVariant
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = articleDto.description,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.subtitle1, color = Color.Gray
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = DateUtils.formatDate(articleDto.publishedAt),
                maxLines = 4,
                overflow = TextOverflow.Ellipsis,
                fontSize = 11.sp,
                style = MaterialTheme.typography.caption, color = Color.Gray
            )


        }
    }
}