package day_3.mapper

import day_3.domain.MathOperation
import day_3.domain.Operation
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MathOperationMapperTest {

    private val mapper = MathOperationMapper()

    @Test
    fun testExampleString() {
        val input = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"

        val actual = mapper.map(input)

        assertEquals(4, actual.size)
        assertEquals(MathOperation(Operation.MULTIPLICATION, 2, 4), actual[0])
        assertEquals(MathOperation(Operation.MULTIPLICATION, 5, 5), actual[1])
        assertEquals(MathOperation(Operation.MULTIPLICATION, 11, 8), actual[2])
        assertEquals(MathOperation(Operation.MULTIPLICATION, 8, 5), actual[3])
    }
}