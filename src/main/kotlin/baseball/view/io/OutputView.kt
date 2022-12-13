package baseball.view.io

import baseball.model.data.GameResult
import baseball.view.strings.Message

class OutputView {

    fun printGameStarted() {
        println(Message.GAME_STARTED)
    }

    fun printInputNumbers() {
        println(Message.INPUT_PLAYER_NUMBER)
    }

    fun printGameResult(result: GameResult) {
        println(buildString {
            if (result.ball != 0) {
                append(result.ball).append(Message.BALL).append(' ')
            }
            if (result.strike != 0) {
                append(result.strike).append(Message.STRIKE)
            }
            if (result.ball == 0 && result.strike == 0) {
                append(Message.NOTHING)
            }
        })
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