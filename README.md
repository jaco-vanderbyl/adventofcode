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
package adventofcode

import adventofcode.year2023.day1.Calibrator

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
}

fun main() {
    App().year2023Day1Puzzle1()
    App().year2023Day1Puzzle2()
    App().year2023Day2Puzzle1()
    App().year2023Day2Puzzle2()
    App().year2023Day3Puzzle1()
}
```
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
```