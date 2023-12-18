package year2023

/**
 * https://adventofcode.com/2023/day/1
 */
class Day1Puzzle2(fileName: String = "year2023/input_day1") {
    private val inputReader = ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()

    fun run() = generateSequence { inputReader?.readLine() }.map { line ->
        mapOf(
            "one" to "o1e", "two" to "t2o", "three" to "t3e", "four" to "f4r", "five" to "f5e",
            "six" to "s6x", "seven" to "s7n", "eight" to "e8t", "nine" to "n9e",
        ).entries.fold(line) { str, (oldValue, newValue) -> str.replace(oldValue, newValue) }
    }.map { line ->
        line.filter { char -> char.isDigit() }.let {
            if (it.isNotEmpty()) "${it.first()}${it.last()}".toInt() else 0
        }
    }.sum()
}
