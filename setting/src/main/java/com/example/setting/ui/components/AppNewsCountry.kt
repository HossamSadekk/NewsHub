package com.example.setting.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.model.dto.language.LanguageDto
import com.example.setting.ui.SettingViewModel


@Composable
fun NewsCountryRow(
    settingName: String,
    icon: Painter,
    onClicked: () -> Unit
) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(12.dp).clickable { onClicked() },
            verticalAlignment = Alignment.CenterVertically
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
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colors.primaryVariant
            )
        }
        Divider(thickness = 0.50.dp, color = Color.Gray)
    }
}

@Composable
fun CustomAlertDialog(
    settingViewModel: SettingViewModel,
    onDismiss: () -> Unit
) {
    var langs = remember { settingViewModel.langs }
    val selectedOptions = remember { mutableStateOf(String) }

    Dialog(
        onDismissRequest = { onDismiss() }, properties = DialogProperties(
            dismissOnBackPress = true, dismissOnClickOutside = true
        )
    ) {
        Card(
            //shape = MaterialTheme.shapes.medium,
            shape = RoundedCornerShape(10.dp),
            // modifier = modifier.size(280.dp, 240.dp)
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            elevation = 8.dp
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .background(MaterialTheme.colors.primary.copy(alpha = 0.4F))
            ) {
                Text(
                    "News Source :",
                    style = MaterialTheme.typography.h3.copy(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(8.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                langs.value.map { languageDto ->
                    CountryCheckedRow(languageDto) { code ->
                        langs.value = langs.value.map { dto ->
                            if (code == dto.code) {
                                settingViewModel.saveCountryState(code)
                                dto.copy(isSelected = true)
                            } else {
                                dto.copy(isSelected = false)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CountryCheckedRow(
    languageDto: LanguageDto,
    onCheckBoxClicked: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            languageDto.name,
            style = MaterialTheme.typography.h3.copy(
                fontSize = 13.sp,
                fontWeight = FontWeight.Light
            )
        )
        Checkbox(
            checked = languageDto.isSelected,
            onCheckedChange = {
                onCheckBoxClicked(languageDto.code)
            },
            colors = CheckboxDefaults.colors(
                checkedColor = MaterialTheme.colors.primaryVariant,    // Color when checked
                uncheckedColor = Color.DarkGray,    // Color when unchecked
                checkmarkColor = MaterialTheme.colors.secondary   // Color of the checkmark
            )
        )
    }
}