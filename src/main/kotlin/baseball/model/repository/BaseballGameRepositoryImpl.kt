package baseball.model.repository

import baseball.model.data.GameNumbers
import baseball.model.data.GameResult
import baseball.model.generator.GameNumbersGenerator

class BaseballGameRepositoryImpl : BaseballGameRepository {

    private lateinit var computerNumbers: GameNumbers

    override fun generateComputerNumbers() {
        computerNumbers = GameNumbersGenerator.byRandom().generate()
    }

    override fun compareComputerNumberWith(userNumbers: GameNumbers): GameResult {
        return GameResult(
            ball = computerNumbers.countBall(userNumbers),
            strike = computerNumbers.countStrike(userNumbers),
        )
    }
}