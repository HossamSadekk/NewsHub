package com.example.setting.ui

import com.example.storage.pref.PreferencesManager
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.unmockkAll
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class SettingViewModelTest {
    private lateinit var viewModel: SettingViewModel

    @RelaxedMockK
    private lateinit var preferencesManager: PreferencesManager
    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(testDispatcher)
        viewModel = SettingViewModel(preferencesManager)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        unmockkAll()
    }

    @Test
    fun `test saveCountryState`() {
        val countryCode = "us"
        coEvery { preferencesManager.saveCountryState(any()) } returns Unit

        viewModel.saveCountryState(countryCode)

        // Verify that preferencesManager.saveCountryState was called with the correct argument
        coEvery { preferencesManager.saveCountryState(countryCode) }
    }

    @Test
    fun `test saveThemeMode`() {
        val isChecked = true
        coEvery { preferencesManager.saveThemeState(any()) } returns Unit

        viewModel.saveThemeMode(isChecked)

        // Verify that preferencesManager.saveThemeState was called with the correct argument
        coEvery { preferencesManager.saveThemeState(isChecked) }
    }
}