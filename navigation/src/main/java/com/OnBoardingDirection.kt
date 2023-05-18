package com

import androidx.navigation.NamedNavArgument

object OnBoardingDirections {

    val root = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "onBoarding"

    }
}