package baseball.view.strings

typealias GameCommand = Command.Game

object Command {

    enum class Game(private val command: String) {
        RETRY("1"), FINISH("2");

        override fun toString(): String = command

        companion object {
            private val values = values().toList()

            operator fun get(command: String): GameCommand = requireNotNull(values().find { it.command == command })

            operator fun contains(command: String): Boolean = values.any { it.command == command }
        }
    }
}