package com.example.testeableapp

import com.example.testeableapp.ui.Screens.calculateTip
import org.junit.Assert.*
import org.junit.Test

class UnitTestsTipCalculator {
    @Test
    fun testTipOf37WithRoundUp() {
        val result = calculateTip(
            amount = 10.00,
            tipPercent = 37,
            roundUp = true
        )
        assertEquals(4.00, result, 0.01)
    }

    @Test
    fun testWithNegativeAmount() {
        val result = calculateTip(
            amount = -10.00,
            tipPercent = 15,
            roundUp = false
        )
        assertEquals(0.0, result, 0.01)
    }

    @Test
    fun testBillWithTipPerPerson() {
        val bill = 100.00
        val tip = calculateTip(
            amount = bill,
            tipPercent = 20,
            roundUp = false
        )
        val numberOfPeople = 5
        val totalPerPerson = (bill + tip) / numberOfPeople

        assertEquals(24.00, totalPerPerson, 0.01)
    }
}