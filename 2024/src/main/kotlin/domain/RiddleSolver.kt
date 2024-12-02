package domain

interface RiddleSolver<I, R> {
    fun calculate(input: I): R
}