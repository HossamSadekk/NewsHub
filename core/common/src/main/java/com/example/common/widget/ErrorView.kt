package com.example.common.widget

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.common.R

@Composable
fun LottieErrorView(errorMessage: String ,action: () -> Unit) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.errorlottie))
    val logoAnimationState =
        animateLottieCompositionAsState(composition = composition)
    Column(
        modifier = Modifier
            .fillMaxSize().padding(top = 100.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        LottieAnimation(
            composition = composition,
            progress = { logoAnimationState.progress }
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = errorMessage,
            style = TextStyle(color = Color.Red , fontSize = 16.sp),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            textAlign = TextAlign.Center
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            shape = RoundedCornerShape(6.dp),
            border = BorderStroke(1.dp, Color.Red),
            onClick = action
        ) {
            Text(text = "Refresh",style = TextStyle(color = Color.Red , fontSize = 12.sp))
        }


    }
}