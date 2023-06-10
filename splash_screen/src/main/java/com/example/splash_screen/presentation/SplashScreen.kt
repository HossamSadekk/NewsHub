package com.example.splash_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.splash_screen.presentation.SplashScreenViewModel
import javax.inject.Inject

@Composable
fun SplashScreen(viewModel: SplashScreenViewModel = hiltViewModel()) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primaryVariant)
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.news))
        val logoAnimationState =
            animateLottieCompositionAsState(composition = composition)
        LottieAnimation(
            composition = composition,
            progress = { logoAnimationState.progress }
        )

        Spacer(
            Modifier
                .fillMaxWidth()
                .height(67.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colors.primaryVariant,
                            MaterialTheme.colors.secondary
                        )
                    )
                ).align(Alignment.BottomCenter)
        )
        Text(
            text = "News Hub",
            modifier = Modifier.align(Alignment.BottomCenter).padding(vertical = 22.dp),
            color = MaterialTheme.colors.primary,
            fontSize = 16.sp,
        )
        if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
            viewModel.navigate()
        }
    }
}