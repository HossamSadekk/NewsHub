package com.example.common.widget

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.common.R

@Composable
fun popUpButton(modifier: Modifier = Modifier,popUp: () -> Unit){
    IconButton(
        onClick = {
        popUp
        },
        modifier = modifier.size(50.dp).padding(start = 10.dp, top = 20.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_arrow_back),
            contentDescription = null,
            modifier = Modifier.size(32.dp),
            tint = MaterialTheme.colors.primaryVariant
        )
    }
}