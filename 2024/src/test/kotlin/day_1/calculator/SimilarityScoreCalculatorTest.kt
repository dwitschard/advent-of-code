package day_1.calculator

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SimilarityScoreCalculatorTest {

    private val similarityScoreCalculator = SimilarityScoreCalculator()

    @Test
    fun calculate() {
        val baseList = listOf(3, 4, 2, 1, 3, 3)
        val comparisonList = listOf(4, 3, 5, 3, 9, 3)

        val result = similarityScoreCalculator.calculate(Pair(baseList, comparisonList))

        assertEquals(31, result)
    }
}