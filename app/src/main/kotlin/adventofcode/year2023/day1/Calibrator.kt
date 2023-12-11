package adventofcode.year2023.day1

class Calibrator(documentFileName: String = "year2023/day1/puzzle1_calibration_document") {
    private val calibrations = mutableListOf<String>()

    init {
        ClassLoader.getSystemResourceAsStream(documentFileName)?.bufferedReader()?.useLines { calibrations.addAll(it) }
    }

    fun sum() : Int = calibrations.map { line -> line.filter { it.digitToIntOrNull() != null } }
        .map { "${it.first()}${it.last()}".toInt() }
        .sum()
}
