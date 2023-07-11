package com.example.common.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.common.R

@Composable
fun GoUp(goToTop: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        FloatingActionButton(
            modifier = Modifier
                .padding(bottom = 80.dp, end = 16.dp)
                .size(50.dp)
                .align(Alignment.BottomEnd),
            onClick = goToTop,
            backgroundColor = MaterialTheme.colors.primary
        ) {
            Icon(
                painter = painterResource(id = R.drawable.round_arrow_upward),
                contentDescription = "go up"
            )
        }
    }
}