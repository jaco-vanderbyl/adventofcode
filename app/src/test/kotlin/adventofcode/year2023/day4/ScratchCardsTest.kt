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
}
