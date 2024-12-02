package day_1

import day_1.calculator.DistanceCalculator
import day_1.calculator.SimilarityScoreCalculator
import day_1.mapper.ColumnInputMapper
import technical.LineFileReader
import technical.RiddleExecutor


fun main() {

    RiddleExecutor(LineFileReader("/01.txt"), ColumnInputMapper(), DistanceCalculator())
        .executeAndPrint("The Distance of the given Input is")

    RiddleExecutor(LineFileReader("/01.txt"), ColumnInputMapper(), SimilarityScoreCalculator())
        .executeAndPrint("The Similarity of the given Input is")
}


