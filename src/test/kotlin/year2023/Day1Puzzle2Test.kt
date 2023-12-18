package year2023

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day1Puzzle2Test {
    @Test fun `ensure total calibration sum is correct using puzzle 2's calculation`() {
        assertEquals(
            expected = 281,
            actual = Day1Puzzle2("year2023/sample_day1_puzzle2").run(),
            message = "Failed to ensure total calibration sum is correct using puzzle 2's calculation."
        )
    }
}
