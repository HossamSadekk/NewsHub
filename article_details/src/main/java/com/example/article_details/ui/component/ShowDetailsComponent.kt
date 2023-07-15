package com.example.article_details.ui.component

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat.startActivity

@Composable
fun ShowFullDetailsButton(url: String) {
    val context = LocalContext.current

    Button(
        onClick = {
            val webIntent: Intent = Uri.parse(url).let { webpage ->
                Intent(Intent.ACTION_VIEW, webpage)
            }
            context.startActivity(webIntent)
        },
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
        modifier = Modifier.padding(7.dp).width(300.dp).height(40.dp),
        elevation = ButtonDefaults.elevation(5.dp)

    ) {
        Text(
            text = "Show Full Details",
            textAlign = TextAlign.Start,
            fontSize = 18.sp,
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.primaryVariant
        )
    }
}
