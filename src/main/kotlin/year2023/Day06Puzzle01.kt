package year2023

/**
 * https://adventofcode.com/2023/day/6
 */
class Day06Puzzle01(fileName: String = "year2023/input_day06") {
    private val inputReader = ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()

    // Determine the number of ways you could beat the record in each race.
    // What do you get if you multiply these numbers together?
    fun run() : Int {
        val inputStr = inputReader?.readText()?.replace("\r\n", "\n") ?: ""
        val records = getRecords(inputStr)
        val times = getTimes(inputStr)

        return times.mapIndexed { index, time ->
            var count = 0
            for (it in 1..<time) if ((time - it) * it > records[index]) count++
            count
        }.reduce { acc, i -> acc * i }
    }

    private fun getTimes(inputStr: String) : List<Int> = parse(inputStr.split("\n")[0])
    private fun getRecords(inputStr: String) : List<Int> = parse(inputStr.split("\n")[1])
    private fun parse(str: String) : List<Int> =  "\\d+".toRegex().findAll(str).map { it.value.toInt() }.toList()
}
