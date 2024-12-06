package day_3.mapper

import day_3.domain.MathOperation
import domain.InputMapper

class FilterMathOperationMapper : InputMapper<String, List<MathOperation>> {

    override fun map(input: String): List<MathOperation> {
        val filteredContentRegex = Regex("(?=don't\\(\\)).*?(?=do\\(\\))", RegexOption.DOT_MATCHES_ALL)
        val cleanedInput = filteredContentRegex.replace(input, "")

        return MathOperationMapper().map(cleanedInput)
    }

}
