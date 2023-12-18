package year2023

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day6Test {
    @Test
    fun `ensure product of better strategies is correct`() {
        val boatRace = Day6("year2023/sample_day6")
        assertEquals(
            expected = 288,
            actual = boatRace.puzzle1(),
            message = "Failed to ensure product of better strategies is correct."
        )
    }

    @Test
    fun `ensure product of better strategies is correct given one big number`() {
        val boatRace = Day6("year2023/sample_day6")
        assertEquals(
            expected = 71503,
            actual = boatRace.puzzle2(),
            message = "Failed to ensure product of better strategies is correct given one big number."
        )
    }
}
