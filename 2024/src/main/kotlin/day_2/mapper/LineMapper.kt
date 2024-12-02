package day_2.mapper

import domain.InputMapper

class LineMapper : InputMapper<List<String>, List<List<Int>>> {

    override fun map(input: List<String>): List<List<Int>> {
        return input
            .map { line ->
                line
                    .split("\\s".toRegex())
                    .toList()
                    .map(String::toInt)
            }
    }
}