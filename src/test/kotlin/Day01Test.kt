import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.Test
import kotlin.test.assertEquals

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
                Day01().sumCalibrationValuesFromInput(
                    listOf(input)
                )
            )
        }
    }

    @Test
    fun `it can sum multiple lines of input`() {
        assertEquals(
            142,
            Day01().sumCalibrationValuesFromInput(
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
    fun `it can sum calibrated input from Day01_input resource to result 54916`() {
        val day01Part1Result = Day01().sumCalibrationValuesFromInput(
            readInput("Day01_input")
        )

        assertEquals(54916, day01Part1Result)
    }

    @TestFactory
    fun `it can solve spelled examples`() = listOf(
        "ninekkbvsfq8seven7321bpdcdh" to 91,
        "ninesixmlfjxhscninehqcdvxf8nzfivetwonehhd" to 91,
        "eightwothree" to 83,
        "two1nine" to 29,
        "abcone2threexyz" to 13,
        "xtwone3four" to 24,
        "4nineeightseven2" to 42,
        "zoneight234" to 14,
        "7pqrstsixteen" to 76,
        "7pqrstSixteen" to 76,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("it can solve $input to $expected") {
            assertEquals(
                expected,
                Day01().sumNormalizedValuesFromInput(
                    listOf(input)
                )
            )
        }
    }

    @Test
    fun `it can sum multiple lines of spelled input`() {
        assertEquals(
            281,
            Day01().sumNormalizedValuesFromInput(
                listOf(
                    "eightwothree",
                    "two1nine",
                    "abcone2threexyz",
                    "xtwone3four",
                    "4nineeightseven2",
                    "zoneight234",
                    "7pqrstsixteen",
                )
            )
        )
    }

    @Test
    fun `it can sum normalized input from Day01_input resource to result 54728`() {
        val day01Part2Result = Day01().sumNormalizedValuesFromInput(
            readInput("Day01_input")
        )

        assertEquals(54728, day01Part2Result)
    }
}