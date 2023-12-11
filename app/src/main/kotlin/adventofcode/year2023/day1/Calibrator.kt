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
            "one" to "one1one",
            "two" to "two2two",
            "three" to "three3three",
            "four" to "four4four",
            "five" to "five5five",
            "six" to "six6six",
            "seven" to "seven7seven",
            "eight" to "eight8eight",
            "nine" to "nine9nine",
        ).entries.fold(it) {string, (spelledNumber, numericString) -> string.replace(spelledNumber, numericString) }
    }.map { line ->
        line.filter { it.digitToIntOrNull() != null }
    }.sumOf {
        if (it.isNotEmpty()) "${it.first()}${it.last()}".toInt() else 0
    }
}
