package com.example.feed.domain.use_case

import com.example.common.extension.DataState
import com.example.common.extension.apiCall
import com.example.common.use_case.UseCase
import com.example.feed.domain.repository.FeedRepository
import com.example.model.dto.mapper.toSourceDtoList
import com.example.model.dto.sources.SourceDto
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class GetSourcesUseCase @Inject constructor (private val feedRepository: FeedRepository):
    UseCase<List<SourceDto>>() {
    override suspend fun FlowCollector<DataState<List<SourceDto>>>.execute() {
        val getSources = feedRepository.getSources().sources.toSourceDtoList()
        val serviceCall = apiCall { getSources }
        emit(serviceCall)
    }

}