package year2023

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day03Puzzle02Test {
    @Test fun `ensure total sum of gear ratios is correct`() {
        assertEquals(
            expected = 467835,
            actual = Day03Puzzle02("year2023/sample_day03").run(),
            message = "Failed to ensure total sum of gear ratios is correct."
        )
    }
}
