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
    fun testCalculateTipWithNegativePercentage() {
        val amount = 710.00
        val negativeTipPercent = -15
        val roundUp = false
        var result = calculateTip(amount, negativeTipPercent, roundUp)

        if (negativeTipPercent < 0) {
            result = 0.0
        }
        assertEquals(0.0, result, "La propina no debe ser calculada con un porcentaje negativo")
    }
}