import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Day01Test {
    @Test
    fun `it can read input from resources`() {
        val input = readInput("Day01_input")
        assertEquals(1000, input.size)
    }

    @TestFactory
    fun `it can solve basic examples`() = listOf(
        "1abc2" to 12,
        "pqr3stu8vwx" to 38,
        "a1b2c3d4e5f" to 15,
        "treb7uchet" to 77,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("it can solve $input to $expected") {
            assertEquals(
                expected,
                Day01().part1SumCalibrationValuesFromInput(
                    listOf(input)
                )
            )
        }
    }

    @Test
    fun `it can sum multiple lines of input`() {
        assertEquals(
            142,
            Day01().part1SumCalibrationValuesFromInput(
                listOf(
                    "1abc2",
                    "pqr3stu8vwx",
                    "a1b2c3d4e5f",
                    "treb7uchet",
                )
            )
        )
    }

    @Test
    fun `it can sum input from Day01_input resource`() {
        val day01Part1Result = Day01().part1SumCalibrationValuesFromInput(
            readInput("Day01_input")
        )

        assertTrue(0 <= day01Part1Result)

        println(day01Part1Result)
    }
}