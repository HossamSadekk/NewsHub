package com.example.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.common.mvvm.SharedViewModel
import com.example.favorites.ui.FavoriteScreen
import com.example.feed.ui.FeedScreen
import com.example.search.ui.SearchScreen

@Composable
fun HomeScreen(sharedViewModel: SharedViewModel) {
    val scaffoldState = rememberScaffoldState()
    /**
     * currentBottomTab is a MutableState object that holds the current selected bottom tab item.
     * setCurrentBottomTab is a function that can be used to update the value of currentBottomTab.
     * **/
    val (currentBottomTab, setCurrentBottomTab) = rememberSaveable {
        mutableStateOf(BottomBarItem.HOME)
    }

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = { HomeBottomNavigation(currentBottomTab, setCurrentBottomTab) },
        content = {
            val modifier = Modifier.padding(it)
            when (currentBottomTab) {
                BottomBarItem.HOME -> FeedScreen(sharedViewModel = sharedViewModel)
                BottomBarItem.SEARCH -> SearchScreen(sharedViewModel = sharedViewModel)
                BottomBarItem.FAVORITE -> FavoriteScreen(sharedViewModel = sharedViewModel)
                else -> {}
            }
        }
    )

}

@Composable
private fun HomeBottomNavigation(
    bottomTab: BottomBarItem,
    setCurrentBottomTab: (BottomBarItem) -> Unit
) {
    val pages = BottomBarItem.values()

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        pages.forEach { page ->
            val selected = page == bottomTab
            val unSelectedColor = Color(0xFF6E6E6E)
            val selectedLabelColor = if (selected) {
                MaterialTheme.colors.primaryVariant
            } else {
                unSelectedColor
            }
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = rememberVectorPainter(image = page.icon),
                        contentDescription = page.title
                    )
                },
                label = {
                    Text(
                        text = page.title,
                        color = selectedLabelColor,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                selected = selected,
                onClick = {
                    setCurrentBottomTab.invoke(page)
                },
                selectedContentColor = selectedLabelColor,
                unselectedContentColor = unSelectedColor,
                alwaysShowLabel = true,
                modifier = Modifier.navigationBarsPadding()
            )
        }
    }

}

