package baseball.view.io

import baseball.view.strings.GameCommand
import baseball.view.validator.InputValidator
import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readUserNumbers(): List<Int> {
        val numbers = Console.readLine()

        InputValidator.validateBallNumbers(numbers)

        return numbers.map(Char::digitToInt)
    }

    fun readRetryOrFinishCommand(): GameCommand {
        val command = Console.readLine()

        InputValidator.validateGameCommand(command)

        return GameCommand[command]
    }
}