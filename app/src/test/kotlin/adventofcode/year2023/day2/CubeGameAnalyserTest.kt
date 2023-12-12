package adventofcode.year2023.day2

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CubeGameAnalyserTest {
    @Test
    fun `ensure total sum of game IDs for possible games is correct`() {
        val gameAnalyser = CubeGameAnalyser("year2023/day2/puzzle1_sample_cube_games_log")
        assertEquals(
            expected = 8,
            actual = gameAnalyser.sumOfGameIds(redMax = 12, greenMax = 13, blueMax = 14),
            message = "Failed to ensure total sum of game IDs for possible games is correct."
        )
    }

    @Test
    fun `ensure total sum of game set powers is correct`() {
        val gameAnalyser = CubeGameAnalyser("year2023/day2/puzzle2_sample_cube_games_log")
        assertEquals(
            expected = 2286,
            actual = gameAnalyser.sumOfGameSetPowers(),
            message = "Failed to ensure total sum of game set powers is correct."
        )
    }
}
