package day_1.calculator

import domain.RiddleSolver
import kotlin.math.max
import kotlin.math.min

class DistanceCalculator : RiddleSolver<Pair<List<Int>, List<Int>>, Int> {

    override fun calculate(input: Pair<List<Int>, List<Int>>): Int {
        val leftColumn = input.first
        val rightColumn = input.second

        if (leftColumn.size != rightColumn.size) {
            throw IllegalArgumentException("Column Sizes need to match!")
        }

        val sortedLeftColumn = leftColumn.sortedByDescending { it }
        val sortedRightColumn = rightColumn.sortedByDescending { it }

        return sortedLeftColumn
            .mapIndexed { index, leftNumber ->
                val rightNumber = sortedRightColumn[index]
                max(leftNumber, rightNumber) - min(leftNumber, rightNumber)
            }
            .sum()
    }
}