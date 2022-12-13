package baseball.view.validator

import baseball.model.data.GameNumbers
import baseball.view.strings.Command
import baseball.view.strings.ErrorMessage

private typealias GameCommand = Command.Game

object InputValidator {

    const val NUMBERS_LENGTH: Int = GameNumbers.LENGTH
    val MIN_NUMBER: Char = GameNumbers.MIN_NUMBER.digitToChar()
    val MAX_NUMBER: Char = GameNumbers.MAX_NUMBER.digitToChar()

    fun validateBallNumbers(numbers: String) {
        require(numbers.length == NUMBERS_LENGTH) { ErrorMessage.INVALID_NUMBER_LENGTH }
        require(numbers.toSet().size == NUMBERS_LENGTH) { ErrorMessage.DUPLICATED_NUMBER }
        require(numbers.any { it in MIN_NUMBER..MAX_NUMBER }) { ErrorMessage.INVALID_NUMBER_RANGE }
    }

    fun validateGameCommand(command: String) {
        require(command in GameCommand) { ErrorMessage.INVALID_GAME_COMMAND }
    }
}