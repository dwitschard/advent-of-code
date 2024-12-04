package day_3.calculator

import day_3.domain.MathOperation
import day_3.domain.Operation
import domain.RiddleSolver

class MathOperationSumCalculator : RiddleSolver<List<MathOperation>, Int> {

    private val operationMap: Map<Operation, (operand1: Int, operand2: Int) -> Int> = mapOf(
        Operation.MULTIPLICATION to { operand1: Int, operand2: Int -> operand1 * operand2 },
        Operation.UNKNOWN to { _: Int, _: Int -> 0 },
    )

    override fun calculate(input: List<MathOperation>): Int {
        return input.sumOf {
            operationMap[it.operation]?.invoke(it.operand1, it.operand2) ?: 0
        }
    }
}