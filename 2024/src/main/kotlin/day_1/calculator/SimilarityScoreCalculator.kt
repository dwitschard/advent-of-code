package day_1.calculator

import domain.RiddleSolver

class SimilarityScoreCalculator : RiddleSolver<Pair<List<Int>, List<Int>>, Int> {

    override fun calculate(input: Pair<List<Int>, List<Int>>): Int {
        val base = input.first
        val compareList = input.second

        val lookupTable = compareList.associateWith { baseNumber -> compareList.count { baseNumber == it } }

        return base.sumOf { element ->
            element * (lookupTable[element] ?: 0)
        }
    }
}