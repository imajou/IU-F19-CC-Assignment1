import java.nio.file.Paths

fun main(args: Array<String>) {

    val path = Paths.get("").toAbsolutePath().toString()
    println("Runpath: $path \n")

    val file: String = Reader.readFile("data/Test1.kt")

    val parser: Parser = Parser(file, ReadSpecs.getOperators())
    parser.parse()
    parser.split()

    val lexer: Lexer = Lexer(parser)
    var token: Lexer.Token? = lexer.nextToken()

    println("Lexer output: \n")
    while (token != null) {
        println(listOf(token.id, token.position, token.data))
        token = lexer.nextToken()
    }
}