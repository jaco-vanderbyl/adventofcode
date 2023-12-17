package adventofcode.year2023

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day5Test{
    @Test
    fun `ensure seed-to-lowest-location is correct`() {
        val seedMap = Day5("adventofcode/year2023/sample_day5")
        assertEquals(
            expected = 35,
            actual = seedMap.puzzle1(),
            message = "Failed to ensure seed-to-lowest-location is correct."
        )
    }

    fun `ensure seed-to-lowest-location is correct given seed ranges`() {
        val seedMap = Day5("adventofcode/year2023/sample_day5")
        assertEquals(
            expected = 46,
            actual = seedMap.puzzle2(),
            message = "Failed to ensure seed-to-lowest-location is correct given seed ranges."
        )
    }
}
