package day_1.calculator

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class DistanceCalculatorTest {

    private val distanceCalculator = DistanceCalculator()

    @Test
    fun calculate() {
        val leftColumn = listOf(3, 4, 2, 1, 3, 3)
        val rightColumn = listOf(4, 3, 5, 3, 9, 3)

        val result = distanceCalculator.calculate(Pair(leftColumn, rightColumn))

        assertEquals(11, result)
    }

}