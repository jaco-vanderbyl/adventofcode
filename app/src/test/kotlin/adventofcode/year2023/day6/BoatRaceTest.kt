package adventofcode.year2023.day6

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BoatRaceTest {
    @Test
    fun `ensure product of better strategies is correct`() {
        val boatRace = BoatRace("year2023/day6/puzzle1_sample_races")
        assertEquals(
            expected = 288,
            actual = boatRace.betterStrategyPart1(),
            message = "Failed to ensure product of better strategies is correct."
        )
    }

    @Test
    fun `ensure product of better strategies is correct given one big number`() {
        val boatRace = BoatRace("year2023/day6/puzzle2_sample_races")
        assertEquals(
            expected = 71503,
            actual = boatRace.betterStrategyPart2(),
            message = "Failed to ensure product of better strategies is correct given one big number."
        )
    }
}
