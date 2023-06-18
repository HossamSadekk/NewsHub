package com.example.feed.ui.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import timber.log.Timber

@Composable
fun LoadingTopheadlines(modifier: Modifier) {
    Card(
        shape = RoundedCornerShape(18.dp),
        elevation = 10.dp,
        modifier = Modifier
            .height(250.dp)
            .padding(start = 7.dp, end = 7.dp)
    ) {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = MaterialTheme.colors.primaryVariant)
        }
    }
}

@Composable
fun ErrorLoadingTopheadlines(modifier: Modifier, error: String, refresh: () -> Unit) {
    Card(
        shape = RoundedCornerShape(18.dp),
        elevation = 10.dp,
        modifier = Modifier
            .height(250.dp)
            .padding(start = 7.dp, end = 7.dp)
    ) {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center
        ) {
            Column {
                Text(
                    text = error, textAlign = TextAlign.Center,
                    style = TextStyle(color = MaterialTheme.colors.primaryVariant, fontSize = 16.sp)
                )
                Spacer(Modifier.height(3.dp))
                Button(shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(1.dp, MaterialTheme.colors.primaryVariant),
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    onClick = {
                        refresh()
                    }) {
                    Text(
                        text = "Refresh",
                        style = TextStyle(
                            color = MaterialTheme.colors.primaryVariant,
                            fontSize = 16.sp
                        )
                    )
                }
            }
        }
    }
}