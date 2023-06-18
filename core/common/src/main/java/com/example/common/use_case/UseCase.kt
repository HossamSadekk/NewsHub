package com.example.common.use_case

import com.example.common.extension.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class UseCase<ReturnType> where ReturnType : Any {

    protected abstract suspend fun FlowCollector<DataState<ReturnType>>.execute()

    suspend operator fun invoke() = flow {
        execute()
    }.flowOn(Dispatchers.IO)
}