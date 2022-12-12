package baseball.app

import baseball.view.io.InputView
import baseball.view.io.OutputView
import baseball.view.views.ConsoleGameView
import baseball.view.views.BaseballGameView

class BaseballGameApplication(private val view: ConsoleGameView) {

    fun run(): Unit = with (view) {
        onInit()

        do {
            onPlay()
        } while (onFinish())

        onDestroy()
    }

    companion object {
        fun newInstance(): BaseballGameApplication = BaseballGameApplication(
            createBaseballGameView()
        )

        private fun createBaseballGameView(): BaseballGameView = BaseballGameView(
            InputView(), OutputView()
        )
    }
}