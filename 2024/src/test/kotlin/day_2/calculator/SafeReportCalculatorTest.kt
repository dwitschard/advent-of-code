package day_2.calculator

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SafeReportCalculatorTest {

    private val calculator = SafeReportCalculator()

    @Test
    fun calculate() {
        val input = listOf(
            listOf(7, 6, 4, 2, 1),
            listOf(1, 2, 7, 8, 9),
            listOf(9, 7, 6, 2, 1),
            listOf(1, 3, 2, 4, 5),
            listOf(8, 6, 4, 4, 1),
            listOf(1, 3, 6, 7, 9)
        )

        val actual = calculator.calculate(input)

        assertEquals(2, actual)
    }

    @Test
    fun testDescendingOrder() {
        assertTrue(calculator.isDescending(listOf(9, 7, 6, 3, 1)))
        assertTrue(calculator.isDescending(listOf(9, 8, 7, 6)))
        assertTrue(calculator.isDescending(listOf(7, 6, 4, 2, 1)))
    }

    @Test
    fun testAscendingOrder() {
        assertTrue(calculator.isAscending(listOf(1,3,4,5,6)))
        assertTrue(calculator.isAscending(listOf(1,4,5,6)))
    }

    @Test
    fun testDescendingOrderWithTooBigStep() {
        assertFalse(calculator.isDescending(listOf(9, 7, 6, 2, 1)))
    }

    @Test
    fun testAscendingOrderWithTooBigStep() {
        assertFalse(calculator.isAscending(listOf(1,5)))
    }

    @Test
    fun testDescendingOrderWithMaxDepth() {
        assertTrue(calculator.isDescending(listOf(9, 8, 8), maxDepth = 1))
    }

    @Test
    fun testAscendingOrderWithMaxDepth() {
        assertTrue(calculator.isAscending(listOf(1, 3), maxDepth = 1))
    }

    @Test
    fun testDescendingOrderWithAscendingLists() {
        assertFalse(calculator.isDescending(listOf(9, 7, 7)))
        assertFalse(calculator.isDescending(listOf(9, 7, 8)))
    }

    @Test
    fun testAscendingOrderWithDescendingLists() {
        assertFalse(calculator.isAscending(listOf(8, 6, 4, 2, 1)))
        assertFalse(calculator.isAscending(listOf(8, 7, 6, 3)))
    }
}