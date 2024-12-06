package day_3.mapper

import day_3.domain.MathOperation
import day_3.domain.Operation
import org.junit.jupiter.api.Assertions
import kotlin.test.Test
import kotlin.test.assertEquals


class FilterMathOperationMapperTest {

    private val mapper = FilterMathOperationMapper()

    @Test
    fun test() {
        val input = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"

        val actual = mapper.map(input)

        assertEquals(2, actual.size)
        Assertions.assertEquals(MathOperation(Operation.MULTIPLICATION, 2, 4), actual[0])
        Assertions.assertEquals(MathOperation(Operation.MULTIPLICATION, 8, 5), actual[1])
    }

    @Test
    fun testMultilineMatch() {
        val input = """
            don't()where(451,986)%]from()mul(335,971),where()^,+mul(109,542);]-when()how()*~mul(209,405)who()&mul(132,427)when()#/>${'$'}]mul(773,709)]select()@<^mul(976,853)@where()mul(999,764)who()?^@mul(117,681)/{mul(940,729);})}mul(892,189)why()>,how() &mul(22,503)%+#mul(740,5)mul(848,467),where()>~#^[mul(827,812)!#?'what()&why()what()mul(365,268)&select()+mul(208,463)mul(676,938)
            ;select()why()^mul(356,375)where()mul(644,829)select()+(&what()&]do()mul(371,455)#}when() 
        """

        val actual = mapper.map(input)

        assertEquals(1, actual.size)
        Assertions.assertEquals(MathOperation(Operation.MULTIPLICATION, 371, 455), actual[0])
    }

}