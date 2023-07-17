package com.example.article_details.ui

import android.app.Activity
import android.view.Window
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.article_details.R
import com.example.common.mvvm.SharedViewModel

@Composable
fun ArticleDetailsScreen(
    sharedViewModel: SharedViewModel,
    viewModel: ArticleDetailsViewModel = hiltViewModel()
) {
    val article = sharedViewModel.article.value
    DetailsContent(article,viewModel)
}