package baseball.view.strings

import baseball.view.validator.InputValidator

object Message {

    const val GAME_STARTED = "숫자 야구 게임을 시작합니다."
    const val GAME_COMPLETED = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
    const val GAME_FINISHED = "게임 종료"

    const val INPUT_PLAYER_NUMBER = "숫자를 입력해주세요 : "

    const val BALL = "볼"
    const val STRIKE = "스트라이크"
    const val NOTHING = "낫싱"
    const val SPACE = " "

    val INPUT_GAME_COMMAND = "게임을 새로 시작하려면 ${GameCommand.RETRY}, 종료하려면 ${GameCommand.FINISH}를 입력하세요."

}