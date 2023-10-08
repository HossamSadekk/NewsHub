package com

object HomeScreenDirections {
    val root = object : NavigationCommand {
        override var destination = "home_graph"
    }

    val homeScreen = object : NavigationCommand {
        override var destination = "homeScreen"
    }

    fun detailsScreen(
    ) = object : NavigationCommand{
        override var destination = "article_details"
    }

    val sourceContentScreen = object : NavigationCommand {
        override var destination = "source_content"
    }

}
