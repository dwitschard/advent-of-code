package day_1.mapper

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ColumnInputMapperTest {

    private var mapper = ColumnInputMapper()

    @Test
    fun testDayOneInputReader() {
        val input = listOf(
            "12345   98765",
            "76542   84217"
        )

        val actual = mapper.map(input)

        assertEquals(listOf(12345, 76542), actual.first)
        assertEquals(listOf(98765, 84217), actual.second)
    }
}