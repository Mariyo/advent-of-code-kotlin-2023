import kotlin.test.Test
import kotlin.test.assertEquals

class Day01Test {

    @Test
    fun `it can read input from resources`() {
        val input = readInput("Day01_input");
        assertEquals(1000, input.size)
    }

}