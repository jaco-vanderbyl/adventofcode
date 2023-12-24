package year2023

/**
 * https://adventofcode.com/2023/day/7
 */
class Day07Puzzle01 (fileName: String = "year2023/input_day07") {
    private val inputReader = ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()

    class Hand(private val cards: String, val bid: Int) {
        private val cardMap: Map<Char,Int> = mapOf(
            '2' to 2, '3' to 3, '4' to 4, '5' to 5, '6' to 6, '7' to 7, '8' to 8,
            '9' to 9, 'T' to 10, 'J' to 11, 'Q' to 12, 'K' to 13, 'A' to 14,
        )

        val type = cards.sumOf { card -> cards.count { it == card } }
        val first = cardMap[cards[0]]
        val second = cardMap[cards[1]]
        val third = cardMap[cards[2]]
        val fourth = cardMap[cards[3]]
        val fifth = cardMap[cards[4]]
    }

    fun run() : Int {
        val inputStr = inputReader?.readText()?.replace("\r\n", "\n") ?: ""

        return inputStr.split("\n").map { line ->
            val input = line.split(" ")
            Hand(input[0], input[1].toInt())
        }.sortedWith(
            compareBy({ it.type }, {it.first}, {it.second}, {it.third}, {it.fourth}, {it.fifth})
        ).mapIndexed { rank, hand ->
            (rank + 1) * hand.bid
        }.sum()
    }
}
