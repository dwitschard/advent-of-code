package utils

interface InputMapper {

}

interface LineInputMapper<A, B> : InputMapper {

    fun mapLines(lines: A): B
}