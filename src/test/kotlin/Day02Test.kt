import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals

class Day02Test {

    @TestFactory
    fun `it determines if game is possible for bag with 12 red, 13 green and 14 blue cubes`() = listOf(
        Game(
            1,
            listOf(
                CubeSet(4, 0, 3),
                CubeSet(1, 2, 6),
                CubeSet(0, 2, 0),
            )
        ) to true,
        Game(
            2,
            listOf(
                CubeSet(0, 2, 1),
                CubeSet(1, 3, 4),
                CubeSet(0, 1, 1),
            )
        ) to true,
        Game(
            3,
            listOf(
                CubeSet(20, 8, 6),
                CubeSet(4, 13, 5),
                CubeSet(1, 5, 0),
            )
        ) to false,
        Game(
            4,
            listOf(
                CubeSet(3, 1, 6),
                CubeSet(6, 3, 0),
                CubeSet(14, 3, 15),
            )
        ) to false,
        Game(
            5,
            listOf(
                CubeSet(6, 3, 1),
                CubeSet(1, 2, 2),
            )
        ) to true,
    ).map { (game, expected) ->
        DynamicTest.dynamicTest("$game should be possible == $expected") {
            assertEquals(
                expected,
                Day02().puzzle1(
                    game,
                    Bag(12, 13, 14)
                )
            )
        }
    }
}