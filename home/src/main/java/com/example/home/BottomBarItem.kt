package com.example.home

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomBarItem(
    val title: String,
    val icon: ImageVector
) {
    HOME(
        title = "Home",
        icon = Icons.Filled.Home
    ),
    SEARCH(
        title = "Search",
        icon = Icons.Rounded.Search
    ),
    FAVORITE(
        title = "Favorite",
        icon = Icons.Rounded.Favorite
    ),
    SETTINGS(
        title = "Settings",
        icon = Icons.Rounded.Settings
    );
}