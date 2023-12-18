package year2023

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day02Puzzle01Test {
    @Test fun `ensure total sum of game IDs for possible games is correct`() {
        assertEquals(
            expected = 8,
            actual = Day02Puzzle01("year2023/sample_day02").run(),
            message = "Failed to ensure total sum of game IDs for possible games is correct."
        )
    }
}
