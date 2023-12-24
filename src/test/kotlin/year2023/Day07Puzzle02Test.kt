package year2023

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day07Puzzle02Test {
    @Test fun `ensure total winnings of hands using Jokers is correct`() {
        assertEquals(
            expected = 5905,
            actual = Day07Puzzle02("year2023/sample_day07").run(),
            message = "Failed to ensure total winnings of hands using Jokers is correct."
        )
    }
}
