package year2023

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day04Puzzle02Test{
    @Test fun `ensure total scratch cards are correct`() {
        assertEquals(
            expected = 30,
            actual = Day04Puzzle02("year2023/sample_day4").run(),
            message = "Failed to ensure total scratch cards are correct."
        )
    }
}
