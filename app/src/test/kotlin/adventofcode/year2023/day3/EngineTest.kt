package adventofcode.year2023.day3

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class EngineTest {
    @Test
    fun `ensure total sum of engine parts is correct`() {
        val engine = Engine("year2023/day3/puzzle1_sample_engine schematic")
        assertEquals(
            expected = 4361,
            actual = engine.sumOfPartNumbers(),
            message = "Failed to ensure total sum of engine parts is correct."
        )
    }
}
