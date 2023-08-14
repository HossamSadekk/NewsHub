package com.example.setting.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storage.pref.PreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(private val preferencesManager: PreferencesManager) :
    ViewModel() {
    var theme: MutableState<Boolean> = mutableStateOf(false)
    val flow = preferencesManager.themeState

    init {
        viewModelScope.launch {
            flow.collect {
                theme.value = it
            }
        }
    }

    fun saveThemeMode(isChecked: Boolean) = viewModelScope.launch {
        preferencesManager.saveThemeState(isChecked)
    }
}