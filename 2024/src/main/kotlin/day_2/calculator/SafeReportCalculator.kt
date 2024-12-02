package day_2.calculator

import domain.RiddleSolver

class SafeReportCalculator(private val levelTolerance: Int = 0) : RiddleSolver<List<List<Int>>, Int> {

    override fun calculate(input: List<List<Int>>): Int {
        val ascendingReports = input.count { line -> isAscending(line) }
        val descendingReports = input.count { line -> isDescending(line) }

        return ascendingReports + descendingReports
    }

    fun isDescending(
        input: List<Int>,
        numberOfLevelsToIgnore: Int = this.levelTolerance
    ): Boolean {

        return checkOrder(
            input = input,
            completeInput = input,
            levelsToIgnore = numberOfLevelsToIgnore,
            comparator = { item0, item1 -> (item0 > item1) && ((item0 - item1) <= 3) },
        )
    }

    fun isAscending(
        input: List<Int>,
        numberOfLevelsToIgnore: Int = this.levelTolerance
    ): Boolean {

        return checkOrder(
            input = input,
            completeInput = input,
            levelsToIgnore = numberOfLevelsToIgnore,
            comparator = { item0, item1 -> (item0 < item1) && ((item1 - item0) <= 3) },
        )
    }

    private fun checkOrder(
        input: List<Int>,
        completeInput: List<Int>,
        levelsToIgnore: Int,
        ignoredLevels: Int = 0,
        currentIndex: Int = 1,
        comparator: (item0: Int, item1: Int) -> Boolean
    ): Boolean {
        if (input.size == 1) {
            return true
        }

        if (comparator(input[0], input[1])) {
            return checkOrder(
                input = input.drop(1),
                completeInput = completeInput,
                levelsToIgnore = levelsToIgnore,
                ignoredLevels = ignoredLevels,
                currentIndex = currentIndex + 1,
                comparator = comparator
            )
        }

        if (levelsToIgnore > ignoredLevels) {
            // check order by removing element that is not working out
            return checkOrder(
                input = completeInput.filterIndexed { index, _ -> index != currentIndex },
                completeInput = input,
                levelsToIgnore = levelsToIgnore,
                ignoredLevels = ignoredLevels + 1,
                currentIndex = currentIndex + 1,
                comparator = comparator
                // check order by removing previously checked element
            ) || checkOrder(
                input = completeInput.filterIndexed { index, _ -> index != currentIndex - 1 },
                completeInput = input,
                levelsToIgnore = levelsToIgnore,
                ignoredLevels = ignoredLevels + 1,
                currentIndex = currentIndex + 1,
                comparator = comparator
            )
        }

        return false
    }


}