package com

import androidx.navigation.NamedNavArgument

object SplashScreenDirections {

    val root = object : NavigationCommand {

        override var arguments = ""

        override val destination = "splash_screen"

    }


    val splashScreen = object : NavigationCommand {

        override var arguments = ""

        override val destination = "splashScreen"

    }

    val onBoarding = object : NavigationCommand {

        override var arguments = ""

        override val destination = "on_boarding_screen"
    }

    val homeScreen = object : NavigationCommand {

        override var arguments = ""

        override val destination = "homeScreen"

    }

    val Default = object : NavigationCommand {

        override var arguments = ""

        override val destination = ""

    }
}