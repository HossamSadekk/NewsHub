package com.example.search.ui

import com.example.common.mvvm.BaseViewState
import com.example.search.domain.use_case.GetArticlesUseCase
import io.mockk.MockKAnnotations
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class SearchViewModelTest {
    private val testDispatcher = TestCoroutineDispatcher()

    private lateinit var viewModel: SearchViewModel
    private val getArticlesUseCase = mockk<GetArticlesUseCase>()

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(testDispatcher)
        viewModel = SearchViewModel(mockk(relaxed = true), getArticlesUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        unmockkAll()
    }

    @Test
    fun `loadArticles with empty query should set uiState to Empty`() {
        // Given
        val query = ""

        // When
        viewModel.onTriggerEvent(SearchEvent.LoadArticles(query))

        // Then
        assert(viewModel.uiState.value is BaseViewState.Empty)
    }


}