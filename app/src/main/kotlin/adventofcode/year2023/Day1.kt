package adventofcode.year2023

/**
 * https://adventofcode.com/2023/day/1
 */
class Day1(fileName: String = "adventofcode/year2023/input_day1") {
    private val calibrations = mutableListOf<String>()

    init {
        ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()?.useLines { calibrations.addAll(it) }
    }

    fun puzzle1() : Int = calibrations.map {
        it.filter { char -> char.isDigit() }
    }.sumOf {
        if (it.isNotEmpty()) "${it.first()}${it.last()}".toInt() else 0
    }

    fun puzzle2() : Int = calibrations.map {
        mapOf(
            "one" to "o1e",
            "two" to "t2o",
            "three" to "t3e",
            "four" to "f4r",
            "five" to "f5e",
            "six" to "s6x",
            "seven" to "s7n",
            "eight" to "e8t",
            "nine" to "n9e",
        ).entries.fold(it) { string, (spelledNumber, numericString) ->
            string.replace(spelledNumber, numericString)
        }
    }.map {
        it.filter { char -> char.isDigit() }
    }.sumOf {
        if (it.isNotEmpty()) "${it.first()}${it.last()}".toInt() else 0
    }
}
