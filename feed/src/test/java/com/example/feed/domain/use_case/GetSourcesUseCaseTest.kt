package com.example.feed.domain.use_case

import app.cash.turbine.test
import app.cash.turbine.turbineScope
import com.example.common.extension.DataState
import com.example.feed.data.repository.FeedRepositoryImpl
import com.example.model.dto.mapper.toSourceDtoList
import com.example.model.dto.sources.SourceDto
import com.example.model.remote.sources.Source
import com.example.model.remote.sources.SourcesResponse
import io.mockk.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.io.IOException

class GetSourcesUseCaseTest {
    private lateinit var feedRepository: FeedRepositoryImpl
    private lateinit var flowCollector: FlowCollector<DataState<List<SourceDto>>>
    private lateinit var getSourcesUseCase: GetSourcesUseCase

    @Test
    fun `execute should emit serviceCall with sources from feedRepository`() = runTest {
        // Given
        val expectedSources =
            SourcesResponse(
                listOf<Source>(
                    Source("", "", "", "", "", "", ""),
                    Source("", "", "", "", "", "", "")
                ), "ok"
            )

        val expectedSourceDtoList = expectedSources.sources.toSourceDtoList()

        coEvery { feedRepository.getSources() } returns expectedSources

        // When

        getSourcesUseCase().test {
            assertTrue((awaitItem() as DataState.Success).result == expectedSourceDtoList)
            coVerify { feedRepository.getSources() }
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `execute should emit error if getSources() failed`() = runTest {
        coEvery { feedRepository.getSources() } throws IOException()
        getSourcesUseCase().catch {
            assertTrue(it.equals(IOException()))
        }
    }


    @Before
    fun setup() {
        // Mock dependencies
        feedRepository = mockk()
        flowCollector = mockk()

        getSourcesUseCase = GetSourcesUseCase(feedRepository)
    }

    @After
    fun teardown() {
        // Clear mocks
        unmockkAll()
    }

}