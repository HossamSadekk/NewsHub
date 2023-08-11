package com.example.common.use_case

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class LocalUseCase<ReturnType> where ReturnType : Any {

    protected abstract suspend fun FlowCollector<ReturnType>.execute()

    suspend operator fun invoke() = flow {
        execute()
    }.flowOn(Dispatchers.IO)
}