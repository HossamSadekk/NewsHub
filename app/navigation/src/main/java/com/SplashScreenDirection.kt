package com

import androidx.navigation.NamedNavArgument

object SplashScreenDirections {

    val root = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "splash_screen"

    }


    val splashScreen = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "splashScreen"

    }

    val Default = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = ""

    }
}