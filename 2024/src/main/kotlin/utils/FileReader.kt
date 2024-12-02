package utils

import java.io.File
import java.net.URL


class FileReader {

    fun readLines(fileName: String): List<String> {
        val file: URL? = object {}.javaClass.getResource(fileName)

        if (file != null) {
            return File(file.toURI()).readLines()
        }

        return emptyList()
    }

    fun readFile(fileName: String): String {
        val inputStream = object {}.javaClass.getResourceAsStream(fileName)

        return inputStream?.bufferedReader(Charsets.UTF_8)?.use { it.readText() }
            ?: "Resource not found: $fileName"
    }

    fun readFileAsLinesUsingGetResourceAsStream(fileName: String) =
        this::class.java.getResourceAsStream(fileName)?.bufferedReader()?.readLines()

}