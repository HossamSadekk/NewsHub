package com.example.common.widget

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.common.utils.DateUtils

/**
 * composed allows you to encapsulate the logic for creating a complex Modifier in a reusable way.
 * It allows you to combine multiple modifiers together into a single modifier,
 * that can be easily applied to any composable function.
 * **/

fun Modifier.shimmerEffect(): Modifier = composed {
    // depending of the size because we need to change the start and the end offsetof our gradient.
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    // rememberInfiniteTransition can be used to create animations that repeat indefinitely over time.
    val transition = rememberInfiniteTransition()
    val startOffsetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(1000)
        )
    )

    background(
        brush = Brush.linearGradient(
            colors = listOf(
                Color(0xFFB8B5B5),
                Color(0xFF8F8B8B),
                Color(0xFFB8B5B5),
            ),
            start = Offset(startOffsetX, 0f),
            end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
        )
    )
        .onGloballyPositioned {
            size = it.size
        }
}

@Composable
fun ShimmerItem() {
    Row(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
        Box(
            modifier = Modifier
                .height(120.dp)
                .width(120.dp)
                .clip(RoundedCornerShape(16.dp))
                .shimmerEffect()
        )
        Spacer(modifier = Modifier.width(10.dp))

        Column(modifier = Modifier.fillMaxWidth().height(120.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(25.dp)
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(20.dp)
                    .shimmerEffect()
            )
        }
    }
}