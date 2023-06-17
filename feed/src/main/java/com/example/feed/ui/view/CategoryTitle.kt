package com.example.feed.ui.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CategoryTitle(
    title: String,
    textColor: Color = MaterialTheme.colors.secondaryVariant,
    startPadding: Dp = 20.dp,
    topPadding: Dp = 0.dp,
    bottomPadding: Dp = 0.dp
) {
    Text(
        text = title,
        style = MaterialTheme.typography.h4,
        color = textColor,
        modifier = Modifier
            .padding(
                start = startPadding,
                top = topPadding,
                bottom = bottomPadding
            )
    )
}