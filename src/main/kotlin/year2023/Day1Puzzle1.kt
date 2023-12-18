package year2023

/**
 * https://adventofcode.com/2023/day/1
 */
class Day1Puzzle1(fileName: String = "year2023/input_day1") {
    private val inputFile = ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()

    fun run() = generateSequence { inputFile?.readLine() }.map { line ->
        line.filter { char -> char.isDigit() }.let {
            if (it.isNotEmpty()) "${it.first()}${it.last()}".toInt() else 0
        }
    }.sum()
}
