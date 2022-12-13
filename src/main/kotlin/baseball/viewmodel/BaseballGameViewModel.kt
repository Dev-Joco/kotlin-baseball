package baseball.viewmodel

import baseball.model.data.GameNumbers
import baseball.model.data.GameResult
import baseball.model.repository.BaseballGameRepository

class BaseballGameViewModel(
    private val repository: BaseballGameRepository
) {

    var isGameCompleted: Boolean = false
        private set

    fun generateComputerNumbers() {
        isGameCompleted = false

        repository.generateComputerNumbers()
    }

    fun compareComputerNumberWith(userNumbers: List<Int>): GameResult {
        check(!isGameCompleted)

        val gameResult = repository.compareComputerNumberWith(
            GameNumbers(userNumbers)
        )
        if (gameResult.strike == GameNumbers.LENGTH) {
            isGameCompleted = true
        }

        return gameResult
    }
}