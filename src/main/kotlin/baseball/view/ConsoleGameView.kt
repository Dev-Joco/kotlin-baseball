package baseball.view

interface ConsoleGameView {

    fun onInit()

    fun onPlay()

    fun onFinish(): Boolean

    fun onDestroy()

}