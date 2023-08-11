package com.example.favorites.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.common.mvvm.SharedViewModel

@Composable
fun FavoriteScreen(
    viewModel: FavoriteViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    val uiStateFavorite = viewModel.uiStateFavorite.collectAsStateWithLifecycle()
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.background,
                elevation = 6.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                /** TopAppBar Content */
                Row(
                    modifier = Modifier.height(51.dp).fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    /** Header */
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.h2,
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                        text = "Favorites",
                    )
                }

            }
        },
    )
    {
        Box(modifier = Modifier.padding(paddingValues = it).fillMaxSize()) {

        }
    }
}