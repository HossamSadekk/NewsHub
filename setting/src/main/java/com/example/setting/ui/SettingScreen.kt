package com.example.setting.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.setting.R
import com.example.setting.ui.components.AppThemeRow

@Composable
fun SettingScreen(settingViewModel: SettingViewModel = hiltViewModel()) {
    val themeState = settingViewModel.theme
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.background,
                elevation = 6.dp,
                modifier = Modifier.fillMaxWidth()
            ) {

                Row(
                    modifier = Modifier.height(51.dp).fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    /** Header */
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.h2,
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                        text = "Settings",
                    )
                }

            }
        },
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(it)) {
            AppThemeRow("App Theme", painterResource(id = R.drawable.paint), themeState) {
                settingViewModel.saveThemeMode(it)
            }

        }

    }
}
