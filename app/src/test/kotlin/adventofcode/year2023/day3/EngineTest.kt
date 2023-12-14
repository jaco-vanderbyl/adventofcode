package adventofcode.year2023.day3

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class EngineTest {
    @Test
    fun `ensure total sum of engine parts is correct`() {
        val engine = Engine("year2023/day3/puzzle1_sample_engine_schematic")
        assertEquals(
            expected = 4361,
            actual = engine.sumOfPartNumbers(),
            message = "Failed to ensure total sum of engine parts is correct."
        )
    }

    @Test
    fun `ensure total sum of gear ratios is correct`() {
        val engine = Engine("year2023/day3/puzzle2_sample_engine_schematic")
        assertEquals(
            expected = 467835,
            actual = engine.sumOfGearRatios(),
            message = "Failed to ensure total sum of gear ratios is correct."
        )
    }
}
