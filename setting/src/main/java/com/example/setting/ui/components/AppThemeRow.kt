package com.example.setting.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun AppThemeRow(
    settingName: String,
    icon: Painter,
    checkedState: MutableState<Boolean>,
    onClicked: (Boolean) -> Unit
) {
    val switchState = remember {
        checkedState
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(12.dp).clickable { }, verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colors.primaryVariant
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                modifier = Modifier.weight(1f),
                text = settingName,
                style = MaterialTheme.typography.h3
            )
            Switch(modifier = Modifier, checked = switchState.value,
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.DarkGray,
                    uncheckedThumbColor = Color.DarkGray,
                    checkedTrackColor = MaterialTheme.colors.primaryVariant,
                    uncheckedTrackColor = MaterialTheme.colors.primaryVariant,
                    uncheckedTrackAlpha = 1.0f
                ),
                onCheckedChange = {
                    switchState.value = it
                    onClicked(it)
                })
        }
        Divider(thickness = 0.50.dp, color = Color.Gray)
    }


}