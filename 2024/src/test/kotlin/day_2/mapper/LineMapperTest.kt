package day_2.mapper

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LineMapperTest {

    private val mapper = LineMapper()

    @Test
    fun testMapping() {
        val input: List<String> = listOf(
            "7 6 4 2 1",
            "1 2 7 8 9",
            "9 7 6 2 1",
            "1 3 2 4 5",
            "8 6 4 4 1",
        )

        val actual = mapper.map(input)

        assertEquals(listOf(7, 6, 4, 2, 1), actual[0])
        assertEquals(listOf(1, 2, 7, 8, 9), actual[1])
        assertEquals(listOf(9, 7, 6, 2, 1), actual[2])
        assertEquals(listOf(1, 3, 2, 4, 5), actual[3])
        assertEquals(listOf(8, 6, 4, 4, 1), actual[4])
    }
}