package year2023

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day7Test {
    @Test
    fun `ensure total winnings of hands is correct`() {
        val camelCards = Day7("year2023/sample_day7")
        assertEquals(
            expected = 6440,
            actual = camelCards.puzzle1(),
            message = "Failed to ensure total winnings of hands is correct."
        )
    }

    @Test
    fun `ensure total winnings of hands using Jokers is correct`() {
        val camelCards = Day7("year2023/sample_day7")
        assertEquals(
            expected = 5905,
            actual = camelCards.puzzle2(),
            message = "Failed to ensure total winnings of hands using Jokers is correct."
        )
    }
}
