package baseball.model.repository

import baseball.model.data.GameNumbers
import baseball.model.data.GameResult

interface BaseballGameRepository {

    fun generateComputerNumbers()

    fun compareComputerNumberWith(userNumbers: GameNumbers): GameResult
}