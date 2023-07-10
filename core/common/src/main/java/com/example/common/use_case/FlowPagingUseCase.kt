package com.example.common.use_case

import androidx.paging.PagingData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

abstract class FlowPagingUseCase<ReturnType : Any> {

    abstract fun execute(parameter: String? = null): Flow<PagingData<ReturnType>>

    operator fun invoke(parameter: String? = null): Flow<PagingData<ReturnType>> = execute(parameter)
        .flowOn(Dispatchers.IO)
}