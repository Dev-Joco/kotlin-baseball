package baseball.model.generator

import baseball.model.data.GameNumbers

class GameNumbersGenerator(private val generator: GameNumberGenerator) {

    fun generate(): GameNumbers {
        return GameNumbers(generateNumbers())
    }

    private fun generateNumbers(): List<Int> {
        val numbers = mutableListOf<Int>()
        while (numbers.size < 3) {
            val randomNumber = generator.generate()
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber)
            }
        }
        return numbers
    }

    companion object {
        fun byRandom(): GameNumbersGenerator = GameNumbersGenerator(
            RandomGameNumberGenerator()
        )
    }
}