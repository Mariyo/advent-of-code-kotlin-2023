import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals

class Day02Test {

    private val game1 = Game(
        1, listOf(
            CubeSet(4, 0, 3),
            CubeSet(1, 2, 6),
            CubeSet(0, 2, 0),
        )
    )

    private val game2 = Game(
        2,
        listOf(
            CubeSet(0, 2, 1),
            CubeSet(1, 3, 4),
            CubeSet(0, 1, 1),
        )
    )

    private val game3 = Game(
        3,
        listOf(
            CubeSet(20, 8, 6),
            CubeSet(4, 13, 5),
            CubeSet(1, 5, 0),
        )
    )

    private val game4 = Game(
        4,
        listOf(
            CubeSet(3, 1, 6),
            CubeSet(6, 3, 0),
            CubeSet(14, 3, 15),
        )
    )

    private val game5 = Game(
        5,
        listOf(
            CubeSet(6, 3, 1),
            CubeSet(1, 2, 2),
        )
    )

    @TestFactory
    fun `it determines if game is possible for bag with 12 red, 13 green and 14 blue cubes`() = listOf(
        game1 to true,
        game2 to true,
        game3 to false,
        game4 to false,
        game5 to true,
    ).map { (game, expected) ->
        DynamicTest.dynamicTest("Game no.${game.id} should be possible == $expected") {
            assertEquals(
                expected,
                Day02().puzzle1IsPossible(
                    game,
                    Bag(12, 13, 14)
                )
            )
        }
    }

    @Test
    fun `it can sum IDs of all possible games`() {
        assertEquals(
            8,
            Day02().puzzle1SumAllPossibleGameIds(
                listOf(game1, game2, game3, game4, game5),
                Bag(12, 13, 14)
            )
        )
    }
}