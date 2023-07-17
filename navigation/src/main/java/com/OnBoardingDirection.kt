package com

import androidx.navigation.NamedNavArgument

object OnBoardingDirections {

    val onBoarding = object : NavigationCommand {

        override var arguments = ""

        override var destination = "on_boarding_screen"
    }

    val homeScreen = object : NavigationCommand {

        override var arguments = ""

        override var destination = "homeScreen"

    }
}