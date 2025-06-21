package com.example.testeableapp

import com.example.testeableapp.ui.Screens.calculateTip
import org.junit.Test
import kotlin.test.assertEquals

class AdditionalUnitTestTipCalculator {

    @Test
    fun calculateTipWithAndWithoutRoundUp() {
        val resultWithoutRoundUp = calculateTip(710.00, 15, false)
        assertEquals(106.50, resultWithoutRoundUp, "La propina sin redondeo no es correcta")
        val resultWithRoundUp = calculateTip(710.00, 15, true)
        assertEquals(107.00, resultWithRoundUp, "La propina con redondeo no es correcta")
    }

    @Test
    fun testTotalPerPersonWithZeroPeople() {
        val amount = 710.00
        val tipPercent = 15
        val roundUp = false
        val numberOfPeople = 0

        val tip = calculateTip(amount, tipPercent, roundUp)
        val totalPerPerson = if (numberOfPeople > 0)
                (amount + tip) / numberOfPeople else 0.0

        assertEquals(0.0, totalPerPerson, "El total por persona no debe ser calculado si el número de personas es 0")
    }



}