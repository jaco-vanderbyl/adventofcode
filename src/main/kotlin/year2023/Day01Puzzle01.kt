package year2023

/**
 * https://adventofcode.com/2023/day/1
 */
class Day01Puzzle01(fileName: String = "year2023/input_day01") {
    private val inputReader = ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()

    // Consider your entire calibration document. What is the sum of all the calibration values?
    fun run() = generateSequence { inputReader?.readLine() }.map { line ->
        line.filter { char -> char.isDigit() }.let {
            if (it.isNotEmpty()) "${it.first()}${it.last()}".toInt() else 0
        }
    }.sum()
}
