# Advent of Code
Kotlin app with [Advent of Code](https://adventofcode.com/) exercises.

## Requirements
* [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

## Build the project and run tests
It is recommended to open the project in the latest released version of
[Intellij IDEA](https://www.jetbrains.com/idea/download) (Community or Ultimate Edition), which will
automatically install the appropriate version of Gradle — the required build tool for the project.

### IntelliJ IDEA
Clone the repo and open the project in IntelliJ IDEA. The IDE will automatically build the project
and run tests.

### Gradle Wrapper
To build manually, clone the repo, change to the project root directory, and run the following command from console:
```
$ ./gradlew build
```
In Windows:
```
$ .\gradlew.bat build
```
_The Gradle Wrapper is the preferred way of starting a Gradle build. The Wrapper downloads (if needed) and then
invokes a specific version of Gradle declared in the build._

## Progress
```kotlin
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
    fun year2023Day6Puzzle1() {
        println("2023 Day6 Puzzle1, Question: What do you get if you multiply these numbers together?")
        println("Answer: ${BoatRace().betterStrategyPart1()}")
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
```
_Note that the answers will differ for individuals as the provided puzzle input for users are different._

Prints:
```
2023 Day1 Puzzle1, Question: What is the not-quite-right sum of all the calibration values?
Answer: 56049
2023 Day1 Puzzle2, Question: What is the sum of all the calibration values?
Answer: 54530
2023 Day2 Puzzle1, Question: What is the sum of the IDs of possible cube games?
Answer: 2476
2023 Day2 Puzzle2, Question: What is the sum of the power of cube game sets?
Answer: 54911
2023 Day3 Puzzle1, Question: What is the sum of all of the part numbers in the engine schematic?
Answer: 525119
2023 Day3 Puzzle2, Question: What is the sum of all of the gear ratios in your engine schematic?
Answer: 76504829
2023 Day4 Puzzle1, Question: How many points are the scratchcards worth in total?
Answer: 28538
2023 Day4 Puzzle2, Question: How many total scratchcards do you end up with?
Answer: 9425061
2023 Day5 Puzzle1, Question: What is the lowest location number that corresponds to any of the initial seed numbers?
Answer: 251346198
2023 Day5 Puzzle2, Question: What is the lowest location number that corresponds to any of the initial seed numbers?
Answer: 72263011
2023 Day6 Puzzle2, Question: How many ways can you beat the record in this one much longer race?
Answer: 46173809
2023 Day7 Puzzle1, Question: What are the total winnings?
Answer: 249390788
2023 Day7 Puzzle2, Question: What are the total winnings using Jokers?
Answer: 248750248
```