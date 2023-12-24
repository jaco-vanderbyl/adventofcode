package year2023

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day07Puzzle01Test {
    @Test fun `ensure total winnings of hands is correct`() {
        assertEquals(
            expected = 6440,
            actual = Day07Puzzle01("year2023/sample_day07").run(),
            message = "Failed to ensure total winnings of hands is correct."
        )
    }
}
