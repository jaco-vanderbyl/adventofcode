package year2023

import kotlin.math.pow

/**
 * https://adventofcode.com/2023/day/4
 */
class Day04Puzzle01(fileName: String = "year2023/input_day04") {
    private val inputReader = ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()

    // How many points are the scratchcards worth in total?
    fun run() : Int = generateSequence { inputReader?.readLine() }.map { row ->
        row.substringAfter(":").split("|").map { numbersStr ->
            numbersStr.trim().replace("\\s+".toRegex(), " ").split(" ").map { numberStr ->
                numberStr.toInt()
            }.toSet()
        }
    }.map { cardNumbers ->
        cardNumbers[0].intersect(cardNumbers[1]).size
    }.filter { winCount ->
        winCount > 0
    }.sumOf { winCount ->
        (2.0).pow(winCount - 1).toInt()
    }
}
