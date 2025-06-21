package com.example.testeableapp

import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.testeableapp.ui.Screens.TipCalculatorScreen
import org.junit.Rule
import org.junit.Test

class AdditionalTestsTIpCalculator {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testOnBillAmountInputChange() {
        composeTestRule.setContent {
            TipCalculatorScreen()
        }
        val billAmountField = composeTestRule.onNodeWithTag("BillAmountInput")
        val tipText = composeTestRule.onNodeWithTag("TipText")

        billAmountField.performTextInput("100.00")
        // Se verifica que el campo ahora contiene el texto ingresado
        billAmountField.assertTextContains("100.00")
    }

    @Test
    fun testOnNumberOfPeopleChange() {
        composeTestRule.setContent {
            TipCalculatorScreen()
        }
        val numberOfPeople = composeTestRule.onNodeWithTag("NumberOfPeopleText")

        // Verifica que el número de personas se incrementó
        composeTestRule.onNodeWithTag("increaseButton").performClick()
        numberOfPeople.assertTextEquals("2")

        // Verifica que el número de personas se decrementó
        composeTestRule.onNodeWithTag("decreaseButton").performClick()
        numberOfPeople.assertTextEquals("1")
    }
}