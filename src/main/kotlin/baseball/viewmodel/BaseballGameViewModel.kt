package baseball.viewmodel

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
        TODO()
    }
}