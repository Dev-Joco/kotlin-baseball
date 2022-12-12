package baseball.view.io

import baseball.view.strings.Message

class OutputView {

    fun printGameStarted() {
        println(Message.GAME_STARTED)
    }

    fun printInputNumbers() {
        println(Message.INPUT_PLAYER_NUMBER)
    }

    fun printMatchingResult(result: Any) {
        TODO()
    }

    fun printGameCompleted() {
        println(Message.GAME_COMPLETED)
    }

    fun printInputGameRetryOrFinishCommand() {
        println(Message.INPUT_GAME_COMMAND)
    }

    fun printErrorMessage() {
        TODO()
    }
}