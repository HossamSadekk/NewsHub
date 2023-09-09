package com.example.newshub

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storage.pref.PreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val preferencesManager: PreferencesManager,
) :
    ViewModel() {

    var theme: MutableState<Boolean> = mutableStateOf(false)
    val themeFlow = preferencesManager.themeState

    init {
        viewModelScope.launch {
            themeFlow.collect {
                theme.value = it
            }
        }
    }


}