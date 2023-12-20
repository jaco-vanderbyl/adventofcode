package year2023

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day04Puzzle01Test{
    @Test fun `ensure total points of scratch cards are correct`() {
        assertEquals(
            expected = 13,
            actual = Day04Puzzle01("year2023/sample_day4").run(),
            message = "Failed to ensure total points of scratch cards are correct."
        )
    }
}
