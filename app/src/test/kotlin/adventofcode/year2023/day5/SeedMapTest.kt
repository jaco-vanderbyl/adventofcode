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

    fun `ensure seed-to-lowest-location is correct given seed ranges`() {
        val seedMap = SeedMap("year2023/day5/puzzle2_sample_seed_maps")
        assertEquals(
            expected = 46,
            actual = seedMap.lowestLocationGivenSeedRanges(),
            message = "Failed to ensure seed-to-lowest-location is correct given seed ranges."
        )
    }
}
