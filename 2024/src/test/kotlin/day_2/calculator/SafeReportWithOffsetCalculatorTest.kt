package day_2.calculator

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SafeReportWithOffsetCalculatorTest {

    private val offsetCalculator = SafeReportCalculator(1)

    @Test
    fun calculateRiddleExample() {
        val input = listOf(
            listOf(7, 6, 4, 2, 1),
            listOf(1, 2, 7, 8, 9),
            listOf(9, 7, 6, 2, 1),
            listOf(1, 3, 2, 4, 5),
            listOf(8, 6, 4, 4, 1),
            listOf(1, 3, 6, 7, 9)
        )

        val actual = offsetCalculator.calculate(input)

        assertEquals(4, actual)
    }

    @Test
    fun assertWrongInputsInRiddleExample() {
        val inputs = listOf(
            listOf(1, 2, 7, 8, 9),
            listOf(9, 7, 6, 2, 1),
        )

        assertEquals(0, offsetCalculator.calculate(inputs))
    }

    @Test
    fun testAscendingWithIgnoredLevel() {
        assertFalse(offsetCalculator.isAscending(listOf(1, 2, 7, 8, 9)))
    }

    @Test
    fun assertLastItemToBeRemoved() {
        assertTrue(offsetCalculator.isAscending(listOf(65, 68, 71, 72, 71)))    // last item
    }

    @Test
    fun assertPriorValidElementToBeRemovedToMakeChainValid() {
        assertTrue(offsetCalculator.isAscending(listOf(21, 22, 25, 23, 24)))    // 4th item to be removed
    }

    @Test
    fun assertEdgeCaseCalculation() {
        val inputs = listOf(
            listOf(48, 46, 47, 49, 51, 54, 56),     // true
            listOf(1, 1, 2, 3, 4, 5),               // true
            listOf(1, 2, 3, 4, 5, 5),               // true
            listOf(5, 1, 2, 3, 4),                  // true
            listOf(9, 12, 9, 11, 14, 16, 17, 20)    // false
        )

        assertEquals(4, offsetCalculator.calculate(inputs))
    }

    @Test
    fun testBothLists() {
        val actual = offsetCalculator.calculate(
            listOf(
                listOf(5, 4, 6, 8, 10),     // true
                listOf(5, 4, 9, 10),        // false
            )
        )

        assertEquals(1, actual)
    }
}