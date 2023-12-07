class Day01 {
    fun sumCalibrationValuesFromInput(input: List<String>): Int {
        var result = 0

        input.forEach {
            result += it.calibrate()
        }

        return result
    }

    fun sumNormalizedValuesFromInput(input: List<String>): Int {
        var result = 0

        input.forEach {
            val normalized = it.normalize().calibrate()

            result += normalized
        }

        return result
    }
}

private fun String.normalize(): String {
    var normalized = ""
    var wordDigit = ""

    run loop@{
        this.lowercase().forEach { oneChar ->
            if (oneChar.isDigit()) {
                normalized += oneChar
                return@loop
            }

            wordDigit += "$oneChar"

            val wordDigitAsDigit = wordDigit
                .replace("one", "1")
                .replace("two", "2")
                .replace("three", "3")
                .replace("four", "4")
                .replace("five", "5")
                .replace("six", "6")
                .replace("seven", "7")
                .replace("eight", "8")
                .replace("nine", "9")

            if (wordDigitAsDigit != wordDigit) {
                normalized += wordDigitAsDigit.replace(Regex("\\D+"), "")
                return@loop
            }
        }
    }

    wordDigit = ""

    run loop@{
        this.lowercase().reversed().forEach { oneChar ->
            if (oneChar.isDigit()) {
                normalized += oneChar
                return@loop
            }

            wordDigit = "$oneChar" + wordDigit

            val wordDigitAsDigit = wordDigit
                .replace("one", "1")
                .replace("two", "2")
                .replace("three", "3")
                .replace("four", "4")
                .replace("five", "5")
                .replace("six", "6")
                .replace("seven", "7")
                .replace("eight", "8")
                .replace("nine", "9")

            if (wordDigitAsDigit != wordDigit) {
                normalized += wordDigitAsDigit.replace(Regex("\\D+"), "")
                return@loop
            }
        }
    }

    return normalized
}

private fun String.calibrate(): Int {
    val calibrated = this.replace(Regex("\\D+"), "")
    val first = calibrated.first()
    val last = calibrated.last()
    val result = "$first$last".toInt()
    return result
}

