package com

object OnBoardingDirections {

    val onBoarding = object : NavigationCommand {
        override var destination = "on_boarding_screen"
    }

    val homeScreen = object : NavigationCommand {
        override var destination = "homeScreen"
    }
}