package com

import com.SplashScreenDirections.Default
import kotlinx.coroutines.flow.MutableStateFlow

class NavigationManager {

    var commands = MutableStateFlow(Default)
    var popUp = MutableStateFlow(false)
    fun navigate(
        directions: NavigationCommand
    ) {
        commands.value = directions
    }
fun setDestination(destination: String){
    commands.value.destination = destination
}
    fun navigateBack() {
        popUp.value = true
    }
}