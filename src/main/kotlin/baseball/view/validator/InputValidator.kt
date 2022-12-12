package baseball.view.validator

import baseball.view.strings.Command
import baseball.view.strings.ErrorMessage

private typealias GameCommand = Command.Game

object InputValidator {

    fun validateBallNumbers(numbers: String) {
        require(numbers.length == 3) { ErrorMessage.INVALID_NUMBER_LENGTH }
        require(numbers.toSet().size == 3) { ErrorMessage.DUPLICATED_NUMBER }
        require(numbers.any { it in '1'..'9' }) { ErrorMessage.INVALID_NUMBER_RANGE }
    }

    fun validateGameCommand(command: String): GameCommand {
        require(command in GameCommand) { ErrorMessage.INVALID_GAME_COMMAND }
        return GameCommand.valueOf(command)
    }
}