package com

import androidx.navigation.NamedNavArgument

object OnBoardingDirections {

    val onBoarding = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "on_boarding_screen"
    }

    val homeScreen = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "homeScreen"

    }
}