object Reader {

    /**
     * Read the contents of a file
     *
     * @param filename Name of a file to read from
     * @return Contents of a file
     */
    fun readFile(filename: String): String {
        return Reader::class.java.getResource(filename).readText()
    }

}
