/**
 * @param file Contents of Kotlin source file
 * @param operators operators to parse
 */
class Parser(var file: String, var operators: List<String>) {

    lateinit var parsed: String         // Parsed code by operators
    lateinit var splitted: List<String> // Splitted code to tokens

    /**
     * Parse Kotlin source code.
     * For every operator, surround it with spaces to divide it from other keywords.
     * This needed to uniquely separate all operators between others.
     */
    fun parse() {
        this.parsed = file
        for (operator in operators) {
            this.parsed = this.parsed.replace(operator, " $operator ")
        }
        this.parsed = this.parsed.replace("\\s+".toRegex(), " ")
    }

    /**
     * Split parsed code to tokens
     */
    fun split() {
        this.splitted = this.parsed.split(" ")
    }
}