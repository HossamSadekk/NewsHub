package com.example.search.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.search.R
import com.example.search.ui.SearchEvent
import com.example.search.ui.SearchViewModel

@Composable
fun SearchTopAppBar(searchViewModel: SearchViewModel) {
    TopAppBar(
        content = {
            TopBarContent {
                searchViewModel.onTriggerEvent(SearchEvent.LoadArticles(it))
            }
        },
        backgroundColor = MaterialTheme.colors.background,
        elevation = 5.dp,
        modifier = Modifier
            .statusBarsPadding()
            .padding(top = 10.dp, start = 16.dp, end = 16.dp)
    )
}

@Composable
fun TopBarContent(
    onQueryChange: (searchQuery: String) -> Unit,
) {
    var query by rememberSaveable { mutableStateOf("") }
    val MainWhiteColor = Color(0xFFF4F4F4)
    val raleway_medium = FontFamily(
        Font(R.font.raleway_medium)
    )
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(MainWhiteColor, shape = RoundedCornerShape(12.dp)),
        shape = RoundedCornerShape(size = 12.dp),
        value = query,
        onValueChange = { newQuery ->
            // If user makes changes to text, immediately updated it.
            query = newQuery
            // To avoid crash, only query when string isn't empty.
            if (newQuery.isNotEmpty()) {
                // Pass latest query to refresh search results.
                onQueryChange(newQuery)
            }
        },
        textStyle = TextStyle(
            fontFamily = raleway_medium,
            fontWeight = FontWeight.Bold,
            color = Black,
            fontSize = 15.sp
        ),
        leadingIcon = {
            Icon(
                modifier = Modifier
                    .size(24.dp),
                imageVector = Icons.Rounded.Search,
                tint = Black,
                contentDescription = "Search"
            )
        },
        placeholder = {
            Text(
                text = "Search For Articles...",
                style = TextStyle(
                    fontFamily = raleway_medium,
                    fontWeight = FontWeight.Bold,
                    color = Black,
                    fontSize = 15.sp
                ),
            )
        },

        )

}