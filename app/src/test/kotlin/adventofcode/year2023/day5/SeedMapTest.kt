package adventofcode.year2023.day5

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SeedMapTest{
    @Test
    fun `ensure seed-to-lowest-location is correct`() {
        val seedMap = SeedMap("year2023/day5/puzzle1_sample_seed_maps")
        assertEquals(
            expected = 35,
            actual = seedMap.lowestLocation(),
            message = "Failed to ensure seed-to-lowest-location is correct."
        )
    }
}
