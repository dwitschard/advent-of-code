import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class _Day_1_Test {

    @Test
    fun testSimilarityCalculation() {
        val baseList = listOf(3, 4, 2, 1, 3, 3)
        val comparisonList = listOf(4, 3, 5, 3, 9, 3)

        val result = Day1().calculateSimilarity(baseList, comparisonList)

        assertEquals(31, result)
    }

    @Test
    fun calculateDistance() {
        val leftColumn = listOf(3, 4, 2, 1, 3, 3)
        val rightColumn = listOf(4, 3, 5, 3, 9, 3)

        val result = Day1().calculateDistance(leftColumn, rightColumn)

        assertEquals(11, result)
    }

    @Test
    fun testDayOneInputReader() {
        val input = listOf(
            "12345   98765",
            "76542   84217"
        )

        val mappedLines = DayOneInputMapper().mapLines(input)

        assertEquals(listOf(12345, 76542), mappedLines.first)
        assertEquals(listOf(98765, 84217), mappedLines.second)
    }

}