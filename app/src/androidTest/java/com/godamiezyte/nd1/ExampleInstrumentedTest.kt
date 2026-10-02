package com.godamiezyte.nd1

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test

class ExampleInstrumentedTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun verifyStartDestination() {

        composeTestRule.setContent {
            AppController()
        }

        composeTestRule
            .onNodeWithTag("home_screen")
            .assertIsDisplayed()
    }
}