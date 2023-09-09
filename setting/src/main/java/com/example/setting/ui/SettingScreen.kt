package com.example.setting.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.setting.R
import com.example.setting.ui.components.AppThemeRow
import com.example.setting.ui.components.CustomAlertDialog
import com.example.setting.ui.components.NewsCountryRow


@Composable
fun SettingScreen(settingViewModel: SettingViewModel = hiltViewModel()) {
    val themeState = settingViewModel.theme

    var showCustomDialog by remember {
        mutableStateOf(false)
    }

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
            AppThemeRow(
                stringResource(id = R.string.app_theme),
                painterResource(id = R.drawable.paint),
                themeState
            ) { checked ->
                // when user switch the theme switcher.
                settingViewModel.saveThemeMode(checked)
            }
            NewsCountryRow(
                "News Source Country",
                painterResource(id = R.drawable.internet)
            ) {
                // when user clicks on changing the country news.
                showCustomDialog = !showCustomDialog
            }

        }

    }
    if (showCustomDialog) {
        CustomAlertDialog(settingViewModel) {
            showCustomDialog = !showCustomDialog
        }
    }
}

