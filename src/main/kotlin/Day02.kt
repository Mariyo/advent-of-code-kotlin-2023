class Day02 {
    fun puzzle1IsPossible(game: Game, bag: Bag): Boolean {
        return bag.hasEnoughColoredCubes(game)
    }

    fun puzzle1SumAllPossibleGameIds(games: List<Game>, bag: Bag): Int {
        return games.filter { game ->
            bag.hasEnoughColoredCubes(game)
        }.sumOf { game ->
            game.id
        }
    }
}

class Game(val id: Int, val cubeSets: List<CubeSet>) {
    override fun toString() = "Game no.$id"
}

class CubeSet(val redCount: Int, val greenCount: Int, val blueCount: Int) {

}

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