package year2023

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day2Test {
    @Test
    fun `ensure total sum of game IDs for possible games is correct`() {
        val gameAnalyser = Day2("year2023/sample_day2")
        assertEquals(
            expected = 8,
            actual = gameAnalyser.puzzle1(redMax = 12, greenMax = 13, blueMax = 14),
            message = "Failed to ensure total sum of game IDs for possible games is correct."
        )
    }

    @Test
    fun `ensure total sum of game set powers is correct`() {
        val gameAnalyser = Day2("year2023/sample_day2")
        assertEquals(
            expected = 2286,
            actual = gameAnalyser.puzzle2(),
            message = "Failed to ensure total sum of game set powers is correct."
        )
    }
}
