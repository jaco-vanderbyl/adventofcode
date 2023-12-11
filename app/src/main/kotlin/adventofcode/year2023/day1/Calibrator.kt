package adventofcode.year2023.day1

class Calibrator(documentFileName: String = "year2023/day1/calibration_document") {
    private val calibrations = mutableListOf<String>()

    init {
        ClassLoader.getSystemResourceAsStream(documentFileName)?.bufferedReader()?.useLines { calibrations.addAll(it) }
    }

    fun sumWithNotQuiteRightCalc() : Int = calibrations.map { line ->
        line.filter { it.digitToIntOrNull() != null }
    }.sumOf {
        if (it.isNotEmpty()) "${it.first()}${it.last()}".toInt() else 0
    }

    fun sum()  = calibrations.map {
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
        ).entries.fold(it) {string, (spelledNumber, numericString) -> string.replace(spelledNumber, numericString) }
    }.map { line ->
        line.filter { it.digitToIntOrNull() != null }
    }.sumOf {
        if (it.isNotEmpty()) "${it.first()}${it.last()}".toInt() else 0
    }
}
