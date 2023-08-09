package com

import androidx.navigation.NamedNavArgument
import com.example.model.dto.article.ArticleDto

object HomeScreenDirections {
    val root = object : NavigationCommand {

        override var arguments = ""

        override var destination = "home_graph"
    }

    val homeScreen = object : NavigationCommand {

        override var arguments = ""

        override var destination = "homeScreen"

    }

    fun detailsScreen(
    ) = object : NavigationCommand{

        override var arguments = ""

        override var destination = "article_details"
    }

    val sourceContentScreen = object : NavigationCommand {

        override var arguments = ""

        override var destination = "source_content"

    }

}
