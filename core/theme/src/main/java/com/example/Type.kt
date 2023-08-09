package com.example.newshub.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.RalewayFonts

val DarkTypography = Typography(
    h1 = TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.Bold,
        color = White,
        fontSize = 28.sp
    ),
    h2 = TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.Bold,
        color = White,
        fontSize = 20.sp
    ),
    h3 = TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.SemiBold,
        color = White,
        fontSize = 15.sp
    ),
    h4 = TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.Bold,
        color = White,
        fontSize = 20.sp
    ),
    h5 = TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.Medium,
        color = White,
        fontSize = 10.sp
    ),
    h6 = TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.Light,
        color = White,
        fontSize = 13.sp,
        lineHeight = 30.sp
    ),
    body1 =
        TextStyle(
            fontFamily = RalewayFonts,
            fontWeight = FontWeight.Bold,
            color = White,
            fontSize = 15.sp,
            lineHeight = 30.sp

    ),
    body2 = TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.Medium,
        color = Black,
        fontSize = 16.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.Medium,
        color = White,
        fontSize = 9.sp
    ),
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        color = White,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.Bold,
        color = White,
        fontSize = 15.sp
    )
)

// set of light material typography styles to start with.
val LightTypography = Typography(
    h1 = TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.Bold,
        color = Black,
        fontSize = 28.sp
    ),
    h2 = TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.Bold,
        color = Black,
        fontSize = 20.sp
    ),
    h3 = TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.SemiBold,
        color = Black,
        fontSize = 15.sp
    ),
    h4 = TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.Medium,
        color = Black,
        fontSize = 15.sp
    ),
    h5 = TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.Medium,
        color = Black,
        fontSize = 10.sp
    ),
    h6 = TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.Light,
        color = Black,
        fontSize = 13.sp,
        lineHeight = 30.sp
    ),
    body1 =
        TextStyle(
            fontFamily = RalewayFonts,
            fontWeight = FontWeight.Bold,
            color = Black,
            fontSize = 15.sp,
            lineHeight = 30.sp

    ),
    body2 = TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.Medium,
        color = White,
        fontSize = 16.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.Medium,
        color = Black,
        fontSize = 9.sp
    ),
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        color = Black,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = RalewayFonts,
        fontWeight = FontWeight.Bold,
        color = White,
        fontSize = 15.sp
    )
)