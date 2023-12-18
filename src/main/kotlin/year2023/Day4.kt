package year2023

import kotlin.math.pow

/**
 * https://adventofcode.com/2023/day/4
 */
class Day4(fileName: String = "year2023/input_day4") {
    private val cards = mutableListOf<String>()

    init {
        ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()?.useLines { cards.addAll(it) }
    }

    fun puzzle1() : Int = cardWins().filter { winCount ->
        winCount > 0
    }.sumOf { winCount ->
        (2.0).pow(winCount - 1).toInt()
    }

    fun puzzle2() : Int {
        val cardCounts = IntArray(cards.size) { 1 }
        val cardWins = cardWins()

        cardCounts.forEachIndexed { card, cardCount ->
            for (i in 1..cardCount) {
                copies(card, cardWins[card]).forEach { cardCounts[it]++ }
            }
        }

        return cardCounts.sum()
    }

    private fun cardWins() : List<Int> = cards.map { row ->
        row.substringAfter(":").split("|").map { numbersStr ->
            numbersStr.trim().replace("\\s+".toRegex(), " ").split(" ").map { numberStr ->
                numberStr.toInt()
            }.toSet()
        }
    }.map { cardNumbers ->
        cardNumbers[0].intersect(cardNumbers[1]).size
    }

    private fun copies(cardIndex: Int, winCount: Int) : Set<Int> = IntArray(winCount) {
        cardIndex + 1 + it
    }.filter {
        it <= cards.size
    }.toSet()
}
