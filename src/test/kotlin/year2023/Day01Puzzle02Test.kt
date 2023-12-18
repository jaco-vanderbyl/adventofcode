package year2023

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day01Puzzle02Test {
    @Test fun `ensure total calibration sum is correct using puzzle 2's calculation`() {
        assertEquals(
            expected = 281,
            actual = Day01Puzzle02("year2023/sample_day01_puzzle02").run(),
            message = "Failed to ensure total calibration sum is correct using puzzle 2's calculation."
        )
    }
}
