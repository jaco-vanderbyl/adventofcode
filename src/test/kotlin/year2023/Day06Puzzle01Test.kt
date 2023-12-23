package year2023

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day06Puzzle01Test {
    @Test fun `ensure product of better strategies is correct`() {
        assertEquals(
            expected = 288,
            actual = Day06Puzzle01("year2023/sample_day06").run(),
            message = "Failed to ensure product of better strategies is correct."
        )
    }
}
