package adventofcode

import adventofcode.year2023.day1.Calibrator
import adventofcode.year2023.day2.CubeGameAnalyser
import adventofcode.year2023.day3.Engine
import adventofcode.year2023.day4.ScratchCards
import adventofcode.year2023.day5.SeedMap
import adventofcode.year2023.day6.BoatRace
import adventofcode.year2023.day7.CamelCards

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
    fun year2023Day2Puzzle2() {
        println("2023 Day2 Puzzle2, Question: What is the sum of the power of cube game sets?")
        println("Answer: ${CubeGameAnalyser().sumOfGameSetPowers()}")
    }
    fun year2023Day3Puzzle1() {
        println("2023 Day3 Puzzle1, Question: What is the sum of all of the part numbers in the engine schematic?")
        println("Answer: ${Engine().sumOfPartNumbers()}")
    }
    fun year2023Day3Puzzle2() {
        println("2023 Day3 Puzzle2, Question: What is the sum of all of the gear ratios in your engine schematic?")
        println("Answer: ${Engine().sumOfGearRatios()}")
    }
    fun year2023Day4Puzzle1() {
        println("2023 Day4 Puzzle1, Question: How many points are the scratchcards worth in total?")
        println("Answer: ${ScratchCards().totalPoints()}")
    }
    fun year2023Day4Puzzle2() {
        println("2023 Day4 Puzzle2, Question: How many total scratchcards do you end up with?")
        println("Answer: ${ScratchCards().totalCards()}")
    }
    fun year2023Day5Puzzle1() {
        println("2023 Day5 Puzzle1, Question: What is the lowest location number that corresponds to any of " +
                "the initial naive seed numbers?")
        println("Answer: ${SeedMap().lowestLocation()}")
    }
    fun year2023Day5Puzzle2() {
        println("2023 Day5 Puzzle2, Question: What is the lowest location number that corresponds to any of " +
                "the initial seed numbers?")
        println("Answer: ${SeedMap().lowestLocationGivenSeedRanges()}")
    }
    fun year2023Day6Puzzle1() {
        println("2023 Day6 Puzzle1, Question: What do you get if you multiply these numbers together?")
        println("Answer: ${BoatRace().betterStrategyPart1()}")
    }
    fun year2023Day6Puzzle2() {
        println("2023 Day6 Puzzle2, Question: How many ways can you beat the record in this one much longer race?")
        println("Answer: ${BoatRace().betterStrategyPart2()}")
    }
    fun year2023Day7Puzzle1() {
        println("2023 Day7 Puzzle1, Question: What are the total winnings?")
        println("Answer: ${CamelCards().totalWinningsPart1()}")
    }
    fun year2023Day7Puzzle2() {
        println("2023 Day7 Puzzle2, Question: What are the total winnings using Jokers?")
        println("Answer: ${CamelCards().totalWinningsPart2()}")
    }
}

fun main() {
    App().year2023Day1Puzzle1()
    App().year2023Day1Puzzle2()
    App().year2023Day2Puzzle1()
    App().year2023Day2Puzzle2()
    App().year2023Day3Puzzle1()
    App().year2023Day3Puzzle2()
    App().year2023Day4Puzzle1()
    App().year2023Day4Puzzle2()
    App().year2023Day5Puzzle1()
    App().year2023Day5Puzzle2()
    App().year2023Day6Puzzle1()
    App().year2023Day6Puzzle2()
    App().year2023Day7Puzzle1()
    App().year2023Day7Puzzle2()
}
