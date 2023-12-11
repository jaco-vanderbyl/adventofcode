package adventofcode.year2023.day1

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CalibratorTest {
    @Test
    fun `ensure total calibration sum is correct`() {
        val calibrator = Calibrator("year2023/day1/puzzle1_sample_calibration_document")
        assertEquals(
            expected = 142,
            actual = calibrator.sum(),
            message = "Failed to ensure total calibration sum is correct."
        )
    }
}
