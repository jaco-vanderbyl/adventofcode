package year2023

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day1Puzzle1Test {
    @Test fun `ensure total calibration sum is correct using puzzle 1's not-quite-right calculation`() {
        assertEquals(
            expected = 142,
            actual = Day1Puzzle1("year2023/sample_day1_puzzle1").run(),
            message = "Failed to ensure total calibration sum is correct using puzzle 1's not-quite-right calculation."
        )
    }
}
