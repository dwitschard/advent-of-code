package day_3.calculator

import day_3.domain.MathOperation
import day_3.domain.Operation
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MathOperationSumCalculatorTest {

    private val mathOperationSumCalculator = MathOperationSumCalculator()

    @Test
    fun testCalculation() {
        val input = listOf(
            MathOperation(Operation.MULTIPLICATION, 2, 4),      // 8
            MathOperation(Operation.MULTIPLICATION, 5, 5),      // 25
            MathOperation(Operation.MULTIPLICATION, 11, 8),     // 88
            MathOperation(Operation.MULTIPLICATION, 8, 5)       // 40
        )

        val actual = mathOperationSumCalculator.calculate(input)

        assertEquals(161, actual)
    }
}