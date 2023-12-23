package year2023

/**
 * https://adventofcode.com/2023/day/6
 */
class Day06Puzzle02(fileName: String = "year2023/input_day06") {
    private val inputReader = ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()

    // How many ways can you beat the record in this one much longer race?
    fun run() : Long {
        val inputStr = inputReader?.readText()?.replace("\r\n", "\n") ?: ""
        val record = getRecord(inputStr)
        val time = getTime(inputStr)

        var count = 0L
        for (it in 1..<time) if ((time - it) * it > record) count++
        return count
    }

    private fun getTime(inputStr: String) : Long = parse(inputStr.split("\n")[0])
    private fun getRecord(inputStr: String) : Long = parse(inputStr.split("\n")[1])
    private fun parse(str: String) : Long =  "\\d+".toRegex().findAll(str).map { it.value }.reduce { acc, i
        -> "$acc$i"
    }.toLong()
}
