package day_3

import day_3.calculator.MathOperationSumCalculator
import day_3.mapper.MathOperationMapper
import day_3.mapper.FilterMathOperationMapper
import technical.BlobFileReader
import technical.RiddleExecutor


fun main() {
    RiddleExecutor(BlobFileReader("/Day_3.txt"), MathOperationMapper(), MathOperationSumCalculator())
        .executeAndPrint("The sum of all read operations is")

    RiddleExecutor(BlobFileReader("/Day_3.txt"), FilterMathOperationMapper(), MathOperationSumCalculator())
        .executeAndPrint("The sum of all read operations, excluding dont\'t statement is")
}
