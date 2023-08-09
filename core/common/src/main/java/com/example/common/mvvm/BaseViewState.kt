package com.example.common.mvvm

sealed class BaseViewState {
    object Loading : BaseViewState()
    object Empty : BaseViewState()
    object Data : BaseViewState()
    data class Error(val throwable: Throwable) : BaseViewState()
}
