package com

import androidx.navigation.NamedNavArgument

object HomeScreenDirections {
    val root = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "home_graph"
    }

    val homeScreen = object : NavigationCommand {

        override val arguments = emptyList<NamedNavArgument>()

        override val destination = "homeScreen"

    }
}
