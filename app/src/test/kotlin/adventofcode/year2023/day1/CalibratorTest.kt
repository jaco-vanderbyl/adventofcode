package adventofcode.year2023.day1

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CalibratorTest {
    @Test
    fun `ensure total calibration sum is correct using puzzle 1's not-quite-right calculation`() {
        val calibrator = Calibrator("year2023/day1/puzzle1_sample_calibration_document")
        assertEquals(
            expected = 142,
            actual = calibrator.sumWithNotQuiteRightCalc(),
            message = "Failed to ensure total calibration sum is correct using puzzle 1's not-quite-right calculation."
        )
    }

    @Test
    fun `ensure total calibration sum is correct using puzzle 2's calculation`() {
        val calibrator = Calibrator("year2023/day1/puzzle2_sample_calibration_document")
        assertEquals(
            expected = 281,
            actual = calibrator.sum(),
            message = "Failed to ensure total calibration sum is correct using puzzle 2's calculation."
        )
    }
}
