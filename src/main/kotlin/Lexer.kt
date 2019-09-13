import java.lang.Integer.parseInt

class Lexer(private val parser: Parser) {
    private var currentPosition: Int = -1                          // Current token position
    var operators: List<String> = ReadSpecs.getOperators()
    var keywords: List<String> = ReadSpecs.getKeywords()

    // List of token keywords
    companion object {
        var OPERATOR = "operator"
        var KEYWORD = "keyword"
        var IDENTIFIER = "identifier"
        var LITERAL = "literal"
        var STRING = "string"
        var SHIT = "invalid"
    }

    /**
     * Representation of a token
     *
     * @param data Contents of a token
     * @param id Token itself
     * @param position Position of a token in table
     */
    class Token(val id: String, val position: Int, val data: String) {
        override fun toString(): String {
            return "id=$id, position=$position, data=$data"
        }
    }

    fun nextToken(): Token? {

        if (currentPosition + 1 == parser.splitted.size) return null

        currentPosition++

        if (this.parser.splitted[currentPosition].isBlank()) return nextToken()

        val tokenData: String = this.parser.splitted[currentPosition]
        val tokenId: String

        tokenId = when {
            operators.contains(tokenData) -> OPERATOR   // Process operator
            keywords.contains(tokenData) -> KEYWORD     // Process keyword
            tokenData[0] == '"' -> STRING               // Process string
            else -> try {
                parseInt(tokenData)
                LITERAL                             // Process literal
            } catch (e: NumberFormatException) {
                if (!tokenData[0].isDigit()) IDENTIFIER // Process identifier
                else SHIT                           // Shit
            }
        }

        return Token(tokenId, currentPosition, tokenData)
    }
}