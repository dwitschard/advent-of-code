package day_3.mapper

import day_3.domain.MathOperation
import day_3.domain.Operation
import domain.InputMapper

class MathOperationMapper : InputMapper<String, List<MathOperation>> {

    override fun map(input: String): List<MathOperation> {
        val mulPattern = Regex("(mul)\\((\\d{1,3}),(\\d{1,3})\\)")

        val matches = mulPattern.findAll(input)

        return matches.map {
            MathOperation(mapOperation(it.groupValues[1]), it.groupValues[2].toInt(), it.groupValues[3].toInt())
        }.toList()
    }

    private fun mapOperation(operation: String): Operation {
        return if (operation == "mul") {
            Operation.MULTIPLICATION
        } else {
            Operation.UNKNOWN
        }
    }
}