package com.example.common.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.extension.DataState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import timber.log.Timber

abstract class Mvvm<T> : ViewModel() {
    private val handler = CoroutineExceptionHandler { _, exception ->
        Timber.tag(SAFE_LAUNCH_EXCEPTION).e(exception)
        handleError(exception)
    }

    abstract fun handleError(exception: Throwable)

    abstract fun startLoading()

    abstract fun onTriggerEvent(eventType: T)

    protected fun safeLaunch(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(handler, block = block)
    }

    protected suspend fun <T> execute(
        callFlow: Flow<DataState<T>>,
        completionHandler: (collect: T) -> Unit = {}
    ) {
        callFlow
            .onStart { startLoading() }
            .catch { handleError(it) }
            .collect { state ->
                when (state) {
                    is DataState.Error -> handleError(state.error)
                    is DataState.Success -> completionHandler.invoke(state.result)
                }
            }
    }

    protected suspend fun <T> call(
        callFlow: Flow<T>,
        completionHandler: (collect: T) -> Unit = {}
    ) {
        callFlow
            .catch { handleError(it) }
            .collect {
                completionHandler.invoke(it)
            }
    }

    companion object {
        private const val SAFE_LAUNCH_EXCEPTION = "ViewModel-ExceptionHandler"
    }
}