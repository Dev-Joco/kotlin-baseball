package baseball.view.strings

import baseball.view.validator.Validator

object Message {

    const val GAME_STARTED = "숫자 야구 게임을 시작합니다."
    const val GAME_COMPLETED = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
    const val GAME_FINISHED = "게임 종료"

    const val INPUT_PLAYER_NUMBER = "숫자를 입력해주세요 : "

    const val BALL = "볼"
    const val STRIKE = "스트라이크"
    const val NOTHING = "낫싱"
    const val SPACE = " "

    val INPUT_GAME_COMMAND = "게임을 새로 시작하려면 ${GameCommand.RESTART}, 종료하려면 ${GameCommand.FINISH}를 입력하세요."

    fun showStartGame() {
        println(GAME_STARTED)
    }

    fun requestUserNumber(read: () -> String): String {
        print(INPUT_PLAYER_NUMBER)

        return Validator.validateNumberFormat(read())
    }

    fun showHint(ball: Int, strike: Int) {
        val hint = mutableListOf<String>()
            .apply {
                if (ball != 0) add("$ball$BALL")
                if (strike != 0) add("$strike$STRIKE")
            }
            .joinToString(SPACE)
            .ifBlank { NOTHING }

        println(hint)
    }

    fun requestRestartGame(read: () -> String): Boolean {
        println(GAME_COMPLETED)
        println(INPUT_GAME_COMMAND)

        return when (Validator.validateGameCommand(read())) {
            GameCommand.RESTART -> true
            GameCommand.FINISH -> false
        }
    }

    fun showFinishGame() {
        println(GAME_FINISHED)
    }
}