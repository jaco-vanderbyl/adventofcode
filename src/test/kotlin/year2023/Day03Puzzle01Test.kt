package year2023

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day03Puzzle01Test {
    @Test fun `ensure total sum of engine parts is correct`() {
        assertEquals(
            expected = 4361,
            actual = Day03Puzzle01("year2023/sample_day03").run(),
            message = "Failed to ensure total sum of engine parts is correct."
        )
    }
}
