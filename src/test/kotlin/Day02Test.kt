import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals

class Day02Test {

    private val bag = Bag(12, 13, 14)

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
                Day02().puzzle1IsPossible(game, bag)
            )
        }
    }

    @Test
    fun `it can sum IDs of all possible games`() {
        assertEquals(
            8,
            Day02().puzzle1SumAllPossibleGameIds(
                listOf(game1, game2, game3, game4, game5),
                bag
            )
        )
    }

    @TestFactory
    fun `it can load game from input string`() = listOf(
        "Game 1: 3 blue, 4 red; 2 green, 6 blue, 1 red; 2 green" to game1,
        "Game 5: 3 green, 1 blue, 6 red; 1 red, 2 green, 2 blue" to game5,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Game from $input should be same as $expected") {
            val resultGame = Day02().loadGameFromInput(input)
            assertEquals(expected.id, resultGame.id)
            assertEquals(expected.cubeSets, resultGame.cubeSets)
        }
    }

    @Test
    fun `it can sum IDs of all games from input`() {
        val inputGames = readInput("Day02_input")
        assertEquals(100, inputGames.size)

        val games = inputGames.map { input ->
            Day02().loadGameFromInput(input)
        }

        assertEquals(100, games.size)

        val sum = Day02().puzzle1SumAllPossibleGameIds(games, bag)

        assertEquals(2679, sum)
    }

}