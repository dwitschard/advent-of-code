package day_1.mapper

import domain.InputMapper

class ColumnInputMapper : InputMapper<List<String>, Pair<List<Int>, List<Int>>> {

    override fun map(input: List<String>): Pair<List<Int>, List<Int>> {
        val leftColumn: MutableList<Int> = mutableListOf()
        val rightColumn: MutableList<Int> = mutableListOf()

        input
            .map { line -> line.split("\\s+".toRegex()) }
            .forEach {
                leftColumn.add((it[0].toInt()))
                rightColumn.add(it[1].toInt())
            }

        return Pair(leftColumn.toList(), rightColumn.toList())
    }
}