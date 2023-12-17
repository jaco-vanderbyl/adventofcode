package adventofcode.year2023.day7

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CamelCardsTest {
    @Test
    fun `ensure total winnings of hands is correct`() {
        val camelCards = CamelCards("year2023/day7/puzzle1_sample_hands")
        assertEquals(
            expected = 6440,
            actual = camelCards.totalWinningsPart1(),
            message = "Failed to ensure total winnings of hands is correct."
        )
    }

    @Test
    fun `ensure total winnings of hands using Jokers is correct`() {
        val camelCards = CamelCards("year2023/day7/puzzle2_sample_hands")
        assertEquals(
            expected = 5905,
            actual = camelCards.totalWinningsPart2(),
            message = "Failed to ensure total winnings of hands using Jokers is correct."
        )
    }
}
