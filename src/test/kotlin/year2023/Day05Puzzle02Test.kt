package year2023

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day05Puzzle02Test{
    @Test fun `ensure seed-to-lowest-location is correct given seed ranges`() {
        assertEquals(
            expected = 46,
            actual = Day05Puzzle02("year2023/sample_day05").run(),
            message = "Failed to ensure seed-to-lowest-location is correct given seed ranges."
        )
    }
}
