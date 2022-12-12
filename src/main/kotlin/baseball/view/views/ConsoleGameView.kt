package baseball.view.views

interface ConsoleGameView {

    fun onInit()

    fun onPlay()

    fun onFinish(): Boolean

    fun onDestroy()

}