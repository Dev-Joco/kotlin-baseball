package baseball.view.validator

import baseball.view.strings.Command
import baseball.view.strings.ErrorMessage

private typealias GameCommand = Command.Game

object Validator {

    fun validateNumberFormat(number: String): String {
        require(number.length == 3) { ErrorMessage.INVALID_NUMBER_LENGTH }
        require(number.toSet().size == 3) { ErrorMessage.DUPLICATED_NUMBER }
        require(number.any { it in '1'..'9' }) { ErrorMessage.INVALID_NUMBER_RANGE }

        return number
    }

    fun validateGameCommand(command: String): GameCommand {
        require(command in GameCommand) { ErrorMessage.INVALID_GAME_COMMAND }
        return GameCommand.valueOf(command)
    }
}