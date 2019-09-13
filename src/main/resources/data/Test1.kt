package data

import java.io.File

class CustomInput {
    object InputType {
        const val CONSOLE = 7
        const val FILE = 11
    }

    companion object {
        fun input(inputType: Int, param: String): List<String?> =
            when (inputType) {
                InputType.FILE -> inputFile(param)
                InputType.CONSOLE -> inputConsole(param)
                else -> throw IllegalArgumentException("Input type required")

            }

        private fun inputConsole(param: String): List<String?> =
            listOf(readLine(), readLine(), readLine(), readLine(), readLine())

        private fun inputFile(param: String): List<String?> = File(param).useLines { it.toList() }
    }
}