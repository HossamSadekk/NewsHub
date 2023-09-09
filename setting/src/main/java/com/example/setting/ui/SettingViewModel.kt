package com.example.setting.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.dto.language.LanguageDto
import com.example.storage.pref.PreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(private val preferencesManager: PreferencesManager) :
    ViewModel() {
    var theme: MutableState<Boolean> = mutableStateOf(false)
    val flow = preferencesManager.themeState

    private var languages = emptyList<LanguageDto>()
    val countryFlow = preferencesManager.countryState
    val langs = mutableStateOf<List<LanguageDto>>(emptyList())


    init {
        languages = getLanguages()
        getLanguage()
        viewModelScope.launch {
            flow.collect {
                theme.value = it
            }
        }
    }

    fun getLanguage() {
        viewModelScope.launch {
            countryFlow.collect { countryCode ->
                languages.map {
                    it.isSelected = it.code == countryCode
                }
            }
        }
        langs.value = languages
    }

    fun saveCountryState(code: String) = viewModelScope.launch {
        preferencesManager.saveCountryState(code)
    }

    fun saveThemeMode(isChecked: Boolean) = viewModelScope.launch {
        preferencesManager.saveThemeState(isChecked)
    }

    fun getLanguages(): List<LanguageDto> {
        return listOf(
            LanguageDto(
                code = "us",
                name = "United States",
                isSelected = false
            ),
            LanguageDto(
                code = "eg",
                name = "Egypt",
                isSelected = false
            ),
            LanguageDto(
                code = "gb",
                name = "United Kingdom",
                isSelected = false
            )
        )
    }
}