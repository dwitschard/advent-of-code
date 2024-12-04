package technical

import java.io.File
import java.net.URL


interface RiddleFileReader<O> {
    fun read(): O
}

class BlobFileReader(private val filename: String) : RiddleFileReader<String> {
    override fun read(): String {
        val inputStream = object {}.javaClass.getResourceAsStream(filename)

        return inputStream?.bufferedReader(Charsets.UTF_8)?.use { it.readText() }
            ?: "Resource not found: $filename"
    }
}

class LineFileReader(private val fileName: String) : RiddleFileReader<List<String>> {

    override fun read(): List<String> {
        val file: URL? = object {}.javaClass.getResource(fileName)

        if (file != null) {
            return File(file.toURI()).readLines()
        }

        return emptyList()
    }

    /*
    fun readFileAsLinesUsingGetResourceAsStream(fileName: String) =
        this::class.java.getResourceAsStream(fileName)?.bufferedReader()?.readLines()
    */

}