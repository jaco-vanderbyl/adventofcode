package adventofcode

import adventofcode.year2023.day1.Calibrator
import adventofcode.year2023.day2.CubeGameAnalyser

/**
 * https://adventofcode.com
 */
class App {
    fun year2023Day1Puzzle1() {
        println("2023 Day1 Puzzle1, Question: What is the not-quite-right sum of all the calibration values?")
        println("Answer: ${Calibrator().sumWithNotQuiteRightCalc()}")
    }
    fun year2023Day1Puzzle2() {
        println("2023 Day1 Puzzle2, Question: What is the sum of all the calibration values?")
        println("Answer: ${Calibrator().sum()}")
    }
    fun year2023Day2Puzzle1() {
        println("2023 Day2 Puzzle1, Question: What is the sum of the IDs of possible cube games?")
        println("Answer: ${CubeGameAnalyser().sumOfGameIds(redMax = 12, greenMax = 13, blueMax = 14)}")
    }
}

fun main() {
    App().year2023Day1Puzzle1()
    App().year2023Day1Puzzle2()
    App().year2023Day2Puzzle1()
}
