package adventofcode.year2023.day4

class ScratchCards(fileName: String = "year2023/day4/scratch_cards") {
    private val cards = mutableListOf<String>()

    init {
        ClassLoader.getSystemResourceAsStream(fileName)?.bufferedReader()?.useLines { cards.addAll(it) }
    }

    fun totalPoints() : Int = cards.map { row ->
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
        doublingSequence(n = winCount - 1)
    }

    private fun doublingSequence(seed: Int = 1, n: Int) : Int = when (n) {
        in 1..20 -> doublingSequence(seed * 2, n - 1)
        else -> seed
    }
}
