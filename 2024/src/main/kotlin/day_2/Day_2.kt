package day_2

import day_2.calculator.SafeReportCalculator
import day_2.mapper.LineMapper
import technical.LineFileReader
import technical.RiddleExecutor

fun main() {

    RiddleExecutor(LineFileReader("/Day_2.txt"), LineMapper(), SafeReportCalculator())
        .executeAndPrint("The number of safe Reports is")

    RiddleExecutor(LineFileReader("/Day_2.txt"), LineMapper(), SafeReportCalculator(1))
        .executeAndPrint("The number of Reports with a level tolerance of 1 is")
}