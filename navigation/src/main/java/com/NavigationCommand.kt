package com

import androidx.navigation.NamedNavArgument

// This is going to define the requirements for a navigation event
interface NavigationCommand {

    var arguments: String

    var destination: String
}