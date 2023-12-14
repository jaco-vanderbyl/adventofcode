package adventofcode.year2023.day4

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ScratchCardsTest{
    @Test
    fun `ensure total points of scratch cards are correct`() {
        val cards = ScratchCards("year2023/day4/puzzle1_sample_scratch_cards")
        assertEquals(
            expected = 13,
            actual = cards.totalPoints(),
            message = "Failed to ensure total points of scratch cards are correct."
        )
    }

    @Test
    fun `ensure total scratch cards are correct`() {
        val cards = ScratchCards("year2023/day4/puzzle2_sample_scratch_cards")
        assertEquals(
            expected = 30,
            actual = cards.totalCards(),
            message = "Failed to ensure total scratch cards are correct."
        )
    }
}
