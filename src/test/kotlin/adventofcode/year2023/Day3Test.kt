package adventofcode.year2023

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day3Test {
    @Test
    fun `ensure total sum of engine parts is correct`() {
        val engine = Day3("adventofcode/year2023/sample_day3")
        assertEquals(
            expected = 4361,
            actual = engine.puzzle1(),
            message = "Failed to ensure total sum of engine parts is correct."
        )
    }

    @Test
    fun `ensure total sum of gear ratios is correct`() {
        val engine = Day3("adventofcode/year2023/sample_day3")
        assertEquals(
            expected = 467835,
            actual = engine.puzzle2(),
            message = "Failed to ensure total sum of gear ratios is correct."
        )
    }
}
