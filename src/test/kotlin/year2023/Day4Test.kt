package year2023

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day4Test{
    @Test
    fun `ensure total points of scratch cards are correct`() {
        val cards = Day4("year2023/sample_day4")
        assertEquals(
            expected = 13,
            actual = cards.puzzle1(),
            message = "Failed to ensure total points of scratch cards are correct."
        )
    }

    @Test
    fun `ensure total scratch cards are correct`() {
        val cards = Day4("year2023/sample_day4")
        assertEquals(
            expected = 30,
            actual = cards.puzzle2(),
            message = "Failed to ensure total scratch cards are correct."
        )
    }
}
