package baseball.app

import baseball.view.ConsoleGameView
import baseball.view.BaseballGameView

class BaseballGameApplication(private val view: ConsoleGameView) {

    fun run(): Unit = with (view) {
        onInit()

        do {
            onPlay()
        } while (onFinish())

        onDestroy()
    }

    companion object {
        fun newInstance(): BaseballGameApplication =
            BaseballGameApplication(BaseballGameView())
    }
}