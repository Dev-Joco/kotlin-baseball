package baseball.view.views

import baseball.model.repository.BaseballGameRepositoryImpl
import baseball.view.io.InputView
import baseball.view.io.OutputView
import baseball.view.strings.GameCommand
import baseball.viewmodel.BaseballGameViewModel

class BaseballGameView(
    private val inputView: InputView,
    private val outputView: OutputView,
) : ConsoleGameView {

    private lateinit var viewModel: BaseballGameViewModel

    override fun onInit() {
        viewModel = BaseballGameViewModel(
            BaseballGameRepositoryImpl()
        )
        viewModel.generateComputerNumbers()

        outputView.printGameStarted()
    }

    override fun onPlay() {
        do {
            val numbers = inputView.readUserNumbers()
            val result = viewModel.compareComputerNumberWith(numbers)

            outputView.printMatchingResult(result)
        } while (viewModel.isCompleted)
    }

    override fun onFinish(): Boolean {
        outputView.printInputGameRetryOrFinishCommand()

        return when(inputView.readRetryOrFinishCommand()) {
            GameCommand.RETRY -> true
            GameCommand.FINISH -> false
        }
    }

    override fun onDestroy() { }
}