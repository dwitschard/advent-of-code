package technical

import domain.InputMapper
import domain.RiddleSolver

class RiddleExecutor<I, O, R>(
    private val fileReader: RiddleFileReader<I>,
    private val mapper: InputMapper<I, O>,
    private val solver: RiddleSolver<O, R>
) {

    fun execute(): R {
        val fileInput = fileReader.read()
        val mappedResult = mapper.map(fileInput)

        return solver.calculate(mappedResult)
    }

    fun executeAndPrint(prefix: String) {
        println(prefix + ": " + execute())
    }
}