import java.io.BufferedReader
import java.io.FileReader
import java.util.*
import kotlin.collections.ArrayList
import kotlin.system.exitProcess

object ReadSpecs {

    /**
     * Parses filetable of key-values with specified format:
     * KEY: 'value'
     *
     * @param filename File to read from
     * @return list of second elements of a filetable
     */
    private fun parseTable(filename: String): ArrayList<String> {
        val input: Scanner?
        try {
            input = Scanner(BufferedReader(FileReader(Reader::class.java.getResource(filename).file)))

        } catch (e: Exception) {
            e.printStackTrace()
            exitProcess(-1)
        }

        val operators = ArrayList<String>()
        while (input.hasNextLine()) {
            val line = input.nextLine()

            val nameAndOperator = line.split(": ".toRegex())
            operators
                .add(
                    nameAndOperator[1]
                        .substring(1, nameAndOperator[1].length - 2)
                )
        }
        return operators
    }

    /**
     * Reads operators from Kotlin specification from default src/tokens/Operators.txt file
     */
    fun getOperators(file: String = "tokens/Operators.txt"): ArrayList<String> {
        return parseTable(file)
    }

    /**
     * Reads operators from Kotlin specification from default src/tokens/Keywords.txt file
     */
    fun getKeywords(file: String = "tokens/Keywords.txt"): ArrayList<String> {
        return parseTable(file)
    }
}