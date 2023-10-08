package com

object SplashScreenDirections {

    val root = object : NavigationCommand {
        override var destination = "splash_screen"
    }


    val splashScreen = object : NavigationCommand {
        override var destination = "splashScreen"
    }

    val onBoarding = object : NavigationCommand {
        override var destination = "on_boarding_screen"
    }

    val homeScreen = object : NavigationCommand {
        override var destination = "homeScreen"
    }

    val Default = object : NavigationCommand {
        override var destination = ""
    }
}