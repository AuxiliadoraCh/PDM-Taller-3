package com.example.testeableapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeRight
import com.example.testeableapp.ui.Screens.TipCalculatorScreen
import org.junit.Rule
import org.junit.Test

class TestUITipCalculator {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun roundUpIsChecked() {

        composeTestRule.setContent {
            TipCalculatorScreen()
        }
        val billAmountField = composeTestRule.onNodeWithTag("BillAmountInput")
        billAmountField.performTextInput("710.00")

        composeTestRule.onNodeWithTag("TipText").assertTextContains("Propina: $106.50")

        val roundUpCheckBox = composeTestRule.onNodeWithTag("TipCheckbox")

        roundUpCheckBox.performClick()

        composeTestRule.onNodeWithTag("TipText").assertTextContains("Propina: $107.00")
    }

    @Test
    fun sliderChange() {
        composeTestRule.setContent {
            TipCalculatorScreen()
        }

        val billAmountField = composeTestRule.onNodeWithTag("BillAmountInput")
        billAmountField.performTextInput("710.00")

        val tipSlider = composeTestRule.onNodeWithTag("TipPercentageSlider")
        tipSlider.performTouchInput{
            swipeRight(startX= 0f, endX = 0.2f, durationMillis = 1200)
        }

        composeTestRule.onNodeWithTag("TipText").assertTextContains("Propina: $106.50")

    }
    @Test
    fun elementUITest() {
        composeTestRule.setContent {
            TipCalculatorScreen()
        }

        composeTestRule.onNodeWithTag("BillAmountInput").assertExists().assertIsDisplayed()

        composeTestRule.onNodeWithTag("TipText").assertExists().assertIsDisplayed()

        composeTestRule.onNodeWithTag("TipCheckbox").assertExists().assertIsDisplayed()

        composeTestRule.onNodeWithTag("TipPercentageSlider").assertExists().assertIsDisplayed()
    }

}
