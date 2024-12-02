package day_2.calculator

import domain.RiddleSolver

class SafeReportCalculator : RiddleSolver<List<List<Int>>, Int> {

    override fun calculate(input: List<List<Int>>): Int {

        val ascendingReports = input
            .filter { line -> isAscending(line, maxDepth = 1) }
            .count { line -> isAscending(line, maxDepth = -1) }

        val descendingReports = input
            .filter { line -> isDescending(line, maxDepth = 1) }
            .count { line -> isDescending(line, maxDepth = -1) }

        return ascendingReports + descendingReports
    }

    fun isDescending(input: List<Int>, maxDepth: Int = -1, depth: Int = 0): Boolean {
        return checkOrder(input, depth, maxDepth) { item0, item1 ->
            item0 > item1 && item0 - item1 <= 3
        }
    }

    fun isAscending(input: List<Int>, maxDepth: Int = -1, depth: Int = 0): Boolean {
        return checkOrder(input, depth, maxDepth) { item0, item1 ->
            item0 < item1 && item1 - item0 <= 3
        }
    }

    fun checkOrder(
        input: List<Int>,
        depth: Int = 0,
        maxDepth: Int = -1,
        comparator: (item0: Int, item1: Int) -> Boolean
    ): Boolean {
        if (input.size == 1 || depth == maxDepth) {
            return true
        }

        if (comparator(input[0], input[1])) {
            return checkOrder(input.drop(1), depth + 1, maxDepth, comparator)
        }

        return false
    }


}