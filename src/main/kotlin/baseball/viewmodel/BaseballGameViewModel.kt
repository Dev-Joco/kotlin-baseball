package baseball.viewmodel

import baseball.model.data.GameResult
import baseball.model.repository.BaseballGameRepository

class BaseballGameViewModel(
    private val repository: BaseballGameRepository
) {

    val isCompleted: Boolean
        get() = TODO()

    fun generateComputerNumbers() {
        TODO()
    }

    fun compareComputerNumberWith(userNumbers: List<Int>): GameResult {
        TODO()
    }
}