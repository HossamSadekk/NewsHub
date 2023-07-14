package com

import androidx.navigation.NamedNavArgument
import com.example.model.dto.article.ArticleDto

object HomeScreenDirections {
    val root = object : NavigationCommand {

        override var arguments = ""

        override val destination = "home_graph"
    }

    val homeScreen = object : NavigationCommand {

        override var arguments = ""

        override val destination = "homeScreen"

    }

    fun detailsScreen(
    ) = object : NavigationCommand{

        override var arguments = ""

        override val destination = "article_details"
    }
}
