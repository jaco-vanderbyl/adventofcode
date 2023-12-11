package adventofcode

import adventofcode.year2023.day1.Calibrator

class App {
    fun day1Puzzle1() {
        println("Day1, Puzzle1, Question: What is the sum of all the calibration values?")
        println("Answer: ${Calibrator().sum()}")
    }
}

fun main() {
    App().day1Puzzle1()
}
