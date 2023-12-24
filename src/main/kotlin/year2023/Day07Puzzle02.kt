package year2023

/**
 * https://adventofcode.com/2023/day/7
 */
class Day07Puzzle02 (fileName: String = "year2023/input_day07") {
    private val inputReader = ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()

    class Hand(private val cards: String, val bid: Int) {
        private val cardMap: Map<Char,Int> = mapOf(
            'J' to 1, '2' to 2, '3' to 3, '4' to 4, '5' to 5, '6' to 6, '7' to 7,
            '8' to 8, '9' to 9, 'T' to 10, 'Q' to 12, 'K' to 13, 'A' to 14,
        )

        val type = calcType()
        val first = cardMap[cards[0]]
        val second = cardMap[cards[1]]
        val third = cardMap[cards[2]]
        val fourth = cardMap[cards[3]]
        val fifth = cardMap[cards[4]]

        private fun calcType() : Int? {
            val typeMap: Map<Int,Int> = mapOf(5 to 0, 7 to 1, 9 to 2, 11 to 3, 13 to 4, 17 to 5, 25 to 6)
            val type = typeMap[cards.sumOf { card -> cards.count { it == card } }]

            val jokerCount = cards.count { it == 'J' }
            if (jokerCount == 0) return type

            return when (type) {
                5 -> 6
                4 -> 6
                3 -> 5
                2 -> if (jokerCount == 1) 4 else 5
                1 -> 3
                0 -> 1
                else -> type
            }
        }
    }

    fun run() : Int {
        val inputStr = inputReader?.readText()?.replace("\r\n", "\n") ?: ""

        return inputStr.split("\n").map {
            val input = it.split(" ")
            Hand(input[0], input[1].toInt())
        }.sortedWith(
            compareBy({ it.type }, {it.first}, {it.second}, {it.third}, {it.fourth}, {it.fifth})
        ).mapIndexed { rank, hand ->
            (rank + 1) * hand.bid
        }.sum()
    }
}
