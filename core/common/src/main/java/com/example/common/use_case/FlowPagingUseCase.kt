package com.example.common.use_case

import androidx.paging.PagingData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

abstract class FlowPagingUseCase<ReturnType : Any> {

    abstract fun execute(): Flow<PagingData<ReturnType>>

    operator fun invoke(): Flow<PagingData<ReturnType>> = execute()
        .flowOn(Dispatchers.IO)
}