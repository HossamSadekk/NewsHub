package com.example.on_boarding.presentation

import androidx.annotation.DrawableRes
import com.example.on_boarding.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object First : OnBoardingPage(
        image = R.drawable.plam,
        title = "Latest News",
        description = "You can see the latest news around the world with news hub right now."
    )

    object Second : OnBoardingPage(
        image = R.drawable.exciting,
        title = "Searching",
        description = "You can search for the news that you want to read about it."
    )

    object Third : OnBoardingPage(
        image = R.drawable.mobile,
        title = "In One Place",
        description = "All news that you found in social media are available on the news hub right now."
    )
}