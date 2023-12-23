package year2023

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day06Puzzle02Test {
    @Test fun `ensure product of better strategies is correct given one big number`() {
        assertEquals(
            expected = 71503,
            actual = Day06Puzzle02("year2023/sample_day06").run(),
            message = "Failed to ensure product of better strategies is correct given one big number."
        )
    }
}
