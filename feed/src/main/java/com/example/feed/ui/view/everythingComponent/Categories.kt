package com.example.feed.ui.view.everythingComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Categories(
    categories: List<String>,
    onSelectCategory: (String) -> Unit,
    selectedCategory: String,
) {
    LazyRow(
        Modifier.fillMaxWidth().padding(start = 7.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(categories.size) {
            categories[it]?.let {category ->
                Text(
                    text = category,
                    style = typography.h6.merge(),
                    color = MaterialTheme.colors.secondaryVariant,
                    modifier = Modifier
                        .clip(
                            shape = RoundedCornerShape(
                                size = 15.dp,
                            ),
                        )
                        .clickable {
                            onSelectCategory(category)
                        }
                        .background(
                            if (category == selectedCategory) {
                                MaterialTheme.colors.primaryVariant
                            } else {
                                Color.Gray
                            }
                        )
                        .padding(
                            10.dp
                        )
                )
            }

        }
    }
}