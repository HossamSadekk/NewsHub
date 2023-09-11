package com.example.splash_screen.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.splash_screen.SplashScreen
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class SplashScreenKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @RelaxedMockK
    lateinit var viewModel: SplashScreenViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        composeTestRule.setContent {
            SplashScreen(viewModel = viewModel)
        }
        // Mock interactions with your ViewModel here
    }

    @Test
    fun testNewsHubTextIsVisibleOnScreen() {
        // Find the Text composable using the test tag
        val text = composeTestRule.onNodeWithTag("NewsHubTxt")
        text.assertExists()
    }

    @Test
    fun testLottieAnimationIsVisibleOnScreen() {
        val lottie = composeTestRule.onNodeWithTag("lottieAnimation")
        lottie.assertIsDisplayed()
    }

}

