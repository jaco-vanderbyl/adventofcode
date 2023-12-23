package year2023

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day05Puzzle01Test{
    @Test fun `ensure seed-to-lowest-location is correct`() {
        assertEquals(
            expected = 35,
            actual = Day05Puzzle01("year2023/sample_day05").run(),
            message = "Failed to ensure seed-to-lowest-location is correct."
        )
    }
}
