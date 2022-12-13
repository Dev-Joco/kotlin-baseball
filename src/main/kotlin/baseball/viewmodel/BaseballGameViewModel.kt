package baseball.viewmodel

import baseball.model.data.GameNumbers
import baseball.model.data.GameResult
import baseball.model.repository.BaseballGameRepository

class BaseballGameViewModel(
    private val repository: BaseballGameRepository
) {

    var isCompleted: Boolean = false
        private set

    fun generateComputerNumbers() {
        isCompleted = false

        repository.generateComputerNumbers()
    }

    fun compareComputerNumberWith(userNumbers: List<Int>): GameResult {
        check(!isCompleted)

        val gameResult = repository.compareComputerNumberWith(
            GameNumbers(userNumbers)
        )
        if (gameResult.strike == GameNumbers.LENGTH) {
            isCompleted = true
        }

        return gameResult
    }
}