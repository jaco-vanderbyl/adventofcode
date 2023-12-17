package adventofcode.year2023

/**
 * https://adventofcode.com/2023/day/7
 */
class Day7 (fileName: String = "adventofcode/year2023/input_day7") {
    private val handsInput = mutableListOf<String>()

    init {
        ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()?.useLines { handsInput.addAll(it) }
    }

    companion object {
        val cardMapNormal: Map<Char,Int> = mapOf(
            '2' to 2, '3' to 3, '4' to 4, '5' to 5, '6' to 6, '7' to 7, '8' to 8,
            '9' to 9, 'T' to 10, 'J' to 11, 'Q' to 12, 'K' to 13, 'A' to 14,
        )
        val cardMapJoker: Map<Char,Int> = mapOf(
            '2' to 2, '3' to 3, '4' to 4, '5' to 5, '6' to 6, '7' to 7, '8' to 8,
            '9' to 9, 'T' to 10, 'J' to 1, 'Q' to 12, 'K' to 13, 'A' to 14,
        )
    }

    class Hand(cardMap: Map<Char,Int>, private val cards: String, val bid: Int, useJoker: Boolean = false) {
        private val typeMap: Map<Int,Int> = mapOf(5 to 0, 7 to 1, 9 to 2, 11 to 3, 13 to 4, 17 to 5, 25 to 6)

        var type = typeMap[cards.sumOf { card -> cards.count { it == card } }] ?: throw IllegalArgumentException()
        val first = cardMap[cards[0]]
        val second = cardMap[cards[1]]
        val third = cardMap[cards[2]]
        val fourth = cardMap[cards[3]]
        val fifth = cardMap[cards[4]]

        init {
            if (useJoker) adjustTypeGivenJokers()
        }

        private fun adjustTypeGivenJokers() {
            val jokerCount = cards.count { it == 'J' }
            if (jokerCount == 0) return

            type = when (type) {
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

    fun puzzle1() = totalWinnings(handsInput.map {
        val input = it.split(" ")
        Hand(cardMapNormal, input[0], input[1].toInt())
    })

    fun puzzle2() = totalWinnings(handsInput.map {
        val input = it.split(" ")
        Hand(cardMapJoker, input[0], input[1].toInt(), useJoker = true)
    })

    private fun totalWinnings(hands: List<Hand>) : Int = hands.sortedWith(
        compareBy({ it.type }, {it.first}, {it.second}, {it.third}, {it.fourth}, {it.fifth})
    ).mapIndexed { rank, hand ->
        (rank + 1) * hand.bid
    }.sum()
}
