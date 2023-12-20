package year2023

/**
 * https://adventofcode.com/2023/day/4
 */
class Day04Puzzle02(fileName: String = "year2023/input_day04") {
    private val inputReader = ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()
    private val cards = inputReader?.readLines() ?: listOf()

    // Process all the original and copied scratchcards until no more scratchcards are won.
    // Including the original set of scratchcards, how many total scratchcards do you end up with?
    fun run() : Int {
        // The index of IntArray represents the card number.
        val cardCounts = IntArray(cards.size) { 1 }
        val winCountPerCard: IntArray = countWinningNumbersPerCard()

        cardCounts.forEachIndexed { card, cardCount -> for (i in 1..cardCount) {
            val cardsWon: Set<Int> = copyCards(card, winCountPerCard[card])
            cardsWon.forEach { cardCounts[it]++ }
        }}

        return cardCounts.sum()
    }

    private fun countWinningNumbersPerCard() : IntArray = cards.map { row ->
        row.substringAfter(":").split("|").map { numbersStr ->
            numbersStr.trim().replace("\\s+".toRegex(), " ").split(" ").map { numberStr ->
                numberStr.toInt()
            }.toSet()
        }
    }.map { cardNumbers ->
        cardNumbers[0].intersect(cardNumbers[1]).size
    }.toIntArray()

    private fun copyCards(card: Int, winCount: Int) : Set<Int> = IntArray(winCount) { offset ->
        card + 1 + offset
    }.filter { it <= cards.size }.toSet()
}
