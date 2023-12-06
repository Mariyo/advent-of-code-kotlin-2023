fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

class Day01 {
    fun part1SumCalibrationValuesFromInput(input: List<String>): Int {
        var result = 0

        input.forEach { oneLine ->
            var first: Char? = null
            var last: Char? = null

            oneLine.forEach { oneChar ->
                if (oneChar.isDigit()) {
                    if (first == null) first = oneChar else last = oneChar
                }
            }

            if (first == null) {
                throw RuntimeException("Invalid input line")
            }

            if (last == null) {
                last = first
            }

            result += ("$first$last").toInt()
        }

        return result
    }

    fun part2(input: List<String>): Int {
        return input.size
    }
}