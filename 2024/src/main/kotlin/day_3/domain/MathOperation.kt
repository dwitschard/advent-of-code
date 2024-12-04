package day_3.domain

data class MathOperation(val operation: Operation, val operand1: Int, val operand2: Int) {
}

enum class Operation {
    MULTIPLICATION,
    UNKNOWN
}
