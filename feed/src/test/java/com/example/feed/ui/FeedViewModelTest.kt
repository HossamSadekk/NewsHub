package com.example.feed.ui

import androidx.paging.PagingData
import com.example.common.extension.DataState
import com.example.feed.domain.use_case.GetArticlesUseCase
import com.example.feed.domain.use_case.GetSourcesUseCase
import com.example.feed.domain.use_case.GetTopHeadlinesUseCase
import com.example.model.dto.article.ArticleDto
import com.example.model.dto.sources.SourceDto
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class FeedViewModelTest {

    @MockK
    private lateinit var getTopHeadlinesUseCase: GetTopHeadlinesUseCase

    @MockK
    private lateinit var getSourcesUseCase: GetSourcesUseCase

    @MockK
    private lateinit var getArticlesUseCase: GetArticlesUseCase

    private lateinit var viewModel: FeedViewModel
    private val testDispatcher = TestCoroutineDispatcher()


    @Before
    fun setup() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(testDispatcher)

        viewModel = FeedViewModel(
            getTopHeadlinesUseCase,
            getSourcesUseCase,
            getArticlesUseCase,
            mockk(relaxed = true) // mock the NavigationManager
        )
    }

    @After
    fun teardown() {
        unmockkAll()
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `loadTopHeadlines should update uiStateFeed with paged top headlines & should update uiState with BaseViewState`() =
        runTest {
            // Given
            val expectedArticles =
                listOf(
                    ArticleDto("", "", "", "", "", ""),
                    ArticleDto(
                        "",
                        "", "", "", "", ""
                    )
                )
            val pagedTopHeadlines: Flow<PagingData<ArticleDto>> =
                flowOf(PagingData.from(expectedArticles))
            every { getTopHeadlinesUseCase() } returns pagedTopHeadlines

            // When
            viewModel.onTriggerEvent(FeedEvent.LoadTopHeadlines)

            // Then
            assertNotNull(viewModel.uiStateFeed.value.topHeadlines)
            assertEquals(viewModel.uiState.value, BaseViewState.Data)
        }

    @Test
    fun `when error happen loadTopHeadlines should update uiState with BaseViewState Error`() =
        runTest {
            // Given
            val expectedError = RuntimeException("Error occurred")
            every { getTopHeadlinesUseCase() } throws expectedError

            // When
            viewModel.onTriggerEvent(FeedEvent.LoadTopHeadlines)

            // Then
            assertEquals(viewModel.uiState.value, BaseViewState.Error(expectedError))
            assertEquals(
                viewModel.uiStateFeed.value.topHeadlines,
                emptyFlow<PagingData<ArticleDto>>()
            )

        }

    @Test
    fun `when success loadArticles should update uiStateFeed with paged articles & update uiState with BaseViewState`() =
        runBlockingTest {
            // Given
            val expectedArticles =
                listOf(
                    ArticleDto("", "", "", "", "", ""),
                    ArticleDto(
                        "",
                        "", "", "", "", ""
                    )
                )
            val selectedCategory = "All"
            val pagedArticles: Flow<PagingData<ArticleDto>> =
                flowOf(PagingData.from(expectedArticles))
            every { getArticlesUseCase(selectedCategory) } returns pagedArticles

            // When
            viewModel.onTriggerEvent(FeedEvent.LoadArticles)

            // Then
            assertNotNull(viewModel.uiStateFeed.value.articles)
            assertEquals(viewModel.uiState.value, BaseViewState.Data)
        }

    @Test
    fun `when failed loadArticles should update uiState with BaseViewState Error`() = runTest {
        // Given
        val expectedError = RuntimeException("Error occurred")
        val selectedCategory = "All"
        every { getArticlesUseCase(selectedCategory) } throws expectedError

        // When
        viewModel.onTriggerEvent(FeedEvent.LoadArticles)

        // Then
        assertEquals(viewModel.uiState.value, BaseViewState.Error(expectedError))
        assertEquals(viewModel.uiStateFeed.value.articles, emptyFlow<PagingData<ArticleDto>>())
    }

    @Test
    fun `when success loadSources should update uiStateFeed with sources list & update uiState`() = runTest {
        // Given
        val sourcesList = listOf(SourceDto("",""),SourceDto("",""))
        coEvery { getSourcesUseCase() } returns flowOf(DataState.Success(sourcesList))

        // When
        viewModel.onTriggerEvent(FeedEvent.LoadSourcesList)

        // Then
        assertNotNull(viewModel.uiStateFeed.value.sourcesList)
        assertEquals(viewModel.uiState.value, BaseViewState.Data)
    }

    @Test
    fun `when failed loadSources should update uiState with Error`() = runTest {
        // Given
        val expectedError = RuntimeException("Error occurred")
        coEvery { getSourcesUseCase() } throws expectedError

        // When
        viewModel.onTriggerEvent(FeedEvent.LoadSourcesList)

        // Then
        assertEquals(viewModel.uiState.value, BaseViewState.Error(expectedError))
        assertEquals(viewModel.uiStateFeed.value.sourcesList, emptyList<List<SourceDto>>())
    }

    @Test
    fun `refreshScreen should call loadTopHeadlines, loadSources, and loadArticles in the expected sequence`() = runBlockingTest {
        // Given
        val sourcesList = listOf(SourceDto("",""),SourceDto("",""))

        coEvery { getTopHeadlinesUseCase() } returns flowOf(PagingData.empty())
        coEvery { getSourcesUseCase() } returns flowOf(DataState.Success(sourcesList))
        coEvery { getArticlesUseCase(any()) } returns flowOf(PagingData.empty())

        // When
        viewModel.onTriggerEvent(FeedEvent.RefreshScreen)

        // Then
        coVerify {
            getTopHeadlinesUseCase()
            getSourcesUseCase()
            getArticlesUseCase(any())
        }
    }

}