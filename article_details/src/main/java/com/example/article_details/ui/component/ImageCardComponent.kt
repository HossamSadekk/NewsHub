package com.example.article_details.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.article_details.R

@Composable
fun ImageCard(url : String?){
    Card(
        shape = RoundedCornerShape(18.dp),
        elevation = 15.dp,
        modifier = Modifier
            .height(250.dp)
            .padding(start = 7.dp, end = 7.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            val painter = rememberImagePainter(
                data = url,
                builder = {
                    crossfade(true)
                    error(R.drawable.placeholder)
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
                .background(
                    Brush.verticalGradient(colors = listOf(
                        Color.Transparent,
                        Color.Black
                    )
                        , startY = 300f
                    ))
            )
        }
    }
}