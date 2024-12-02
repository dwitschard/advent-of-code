package domain

interface InputMapper<A, B> {

    fun map(input: A): B
}