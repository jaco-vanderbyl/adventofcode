package year2023

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day02Puzzle02Test {
    @Test fun `ensure total sum of game set powers is correct`() {
        assertEquals(
            expected = 2286,
            actual = Day02Puzzle02("year2023/sample_day02").run(),
            message = "Failed to ensure total sum of game set powers is correct."
        )
    }
}
