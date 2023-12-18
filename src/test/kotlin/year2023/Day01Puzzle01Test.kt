package year2023

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day01Puzzle01Test {
    @Test fun `ensure total calibration sum is correct using puzzle 1's not-quite-right calculation`() {
        assertEquals(
            expected = 142,
            actual = Day01Puzzle01("year2023/sample_day01_puzzle01").run(),
            message = "Failed to ensure total calibration sum is correct using puzzle 1's not-quite-right calculation."
        )
    }
}
