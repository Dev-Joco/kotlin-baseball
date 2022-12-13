package baseball.model.generator

import baseball.model.data.GameNumbers

class GameNumbersGenerator(private val generator: GameNumberGenerator) {

    fun generate(): GameNumbers {
        return GameNumbers(generator.generate())
    }

    companion object {
        fun byRandom(): GameNumbersGenerator = GameNumbersGenerator(
            RandomGameNumbersGenerator()
        )
    }
}