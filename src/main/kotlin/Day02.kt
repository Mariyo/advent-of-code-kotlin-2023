class Day02(private val bag: Bag) {
    fun puzzle1IsPossible(game: Game): Boolean {
        return bag.hasEnoughColoredCubes(game)
    }

    fun puzzle1SumAllPossibleGameIds(games: List<Game>): Int {
        return games.filter { game ->
            bag.hasEnoughColoredCubes(game)
        }.sumOf { game ->
            game.id
        }
    }

    fun loadGameFromInput(input: String): Game {
        val gameSegments = input.split(":")

        if (gameSegments.size != 2) throw RuntimeException("Invalid Game input")

        val cubeSets = mutableListOf<CubeSet>()
        val redRegex = Regex("(\\d+)\\s+red")
        val greenRegex = Regex("(\\d+)\\s+green")
        val blueRegex = Regex("(\\d+)\\s+blue")

        gameSegments[1].split(";").forEach { cubeSegment ->
            val redCount = redRegex.find(cubeSegment)?.groups?.get(1)?.value?.toInt() ?: 0
            val greenCount = greenRegex.find(cubeSegment)?.groups?.get(1)?.value?.toInt() ?: 0
            val blueCount = blueRegex.find(cubeSegment)?.groups?.get(1)?.value?.toInt() ?: 0

            cubeSets.add(
                CubeSet(redCount, greenCount, blueCount)
            )
        }

        return Game(
            gameSegments[0].replace("Game ", "").toInt(),
            cubeSets
        )
    }

    fun puzzle1SumAllPossibleGameIdsFromFile(fileName: String): Int {
        return readInput(fileName)
            .map { input ->
                Day02(bag).loadGameFromInput(input)
            }
            .filter { game ->
                bag.hasEnoughColoredCubes(game)
            }
            .sumOf { game ->
                game.id
            }
    }
}

data class Game(val id: Int, val cubeSets: List<CubeSet>)

data class CubeSet(val redCount: Int, val greenCount: Int, val blueCount: Int)

class Bag(private val redTotal: Int, private val greenTotal: Int, private val blueTotal: Int) {
    fun hasEnoughColoredCubes(game: Game): Boolean {
        game.cubeSets.forEach { cubeSet ->
            when {
                cubeSet.redCount > redTotal -> return false
                cubeSet.greenCount > greenTotal -> return false
                cubeSet.blueCount > blueTotal -> return false
            }
        }

        return true
    }

}