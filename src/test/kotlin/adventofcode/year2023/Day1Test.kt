package adventofcode.year2023

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day1Test {
    @Test
    fun `ensure total calibration sum is correct using puzzle 1's not-quite-right calculation`() {
        val calibrator = Day1("adventofcode/year2023/sample_day1_puzzle1")
        assertEquals(
            expected = 142,
            actual = calibrator.puzzle1(),
            message = "Failed to ensure total calibration sum is correct using puzzle 1's not-quite-right calculation."
        )
    }

    @Test
    fun `ensure total calibration sum is correct using puzzle 2's calculation`() {
        val calibrator = Day1("adventofcode/year2023/sample_day1_puzzle2")
        assertEquals(
            expected = 281,
            actual = calibrator.puzzle2(),
            message = "Failed to ensure total calibration sum is correct using puzzle 2's calculation."
        )
    }
}
