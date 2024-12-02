import utils.FileReader
import utils.LineInputMapper
import kotlin.math.max
import kotlin.math.min


fun main() {
    val day1 = Day1(DayOneInputMapper())

    val input = day1.inputMapper.mapLines(FileReader().readLines("/01.txt"))

    val distance = day1.calculateDistance(input.first, input.second)
    println("The Distance of the given Input is: $distance")

    val similarityScore = day1.calculateSimilarity(input.first, input.second)
    println("The Similarity of the given Input is: $similarityScore")
}


class Day1(val inputMapper: LineInputMapper<List<String>, Pair<List<Int>, List<Int>>>) {

    fun calculateSimilarity(base: List<Int>, compareList: List<Int>): Int {
        val lookupTable = compareList.associateWith { baseNumber -> compareList.count { baseNumber == it } }

        return base.sumOf { element ->
            element * (lookupTable[element] ?: 0)
        }
    }

    fun calculateDistance(leftColumn: List<Number>, rightColumn: List<Number>): Int {
        if (leftColumn.size != rightColumn.size) {
            throw IllegalArgumentException("Column Sizes need to match!")
        }

        val sortedLeftColumn = leftColumn.sortedByDescending { it.toInt() }
        val sortedRightColumn = rightColumn.sortedByDescending { it.toInt() }

        return sortedLeftColumn
            .map { it.toInt() }
            .mapIndexed { index, leftNumber ->
                val rightNumber = sortedRightColumn[index].toInt()
                max(leftNumber, rightNumber) - min(leftNumber, rightNumber)
            }
            .sum()
    }

}


class DayOneInputMapper: LineInputMapper<List<String>, Pair<List<Int>, List<Int>>> {
    override fun mapLines(lines: List<String>): Pair<List<Int>, List<Int>> {
        val leftColumn: MutableList<Int> = mutableListOf()
        val rightColumn: MutableList<Int> = mutableListOf()

        lines
            .map { line -> line.split("\\s+".toRegex()) }
            .forEach {
                leftColumn.add((it[0].toInt()))
                rightColumn.add(it[1].toInt())
            }

        return Pair(leftColumn.toList(), rightColumn.toList())
    }
}