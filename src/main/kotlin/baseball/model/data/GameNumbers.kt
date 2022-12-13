package baseball.model.data

class GameNumbers(private val numbers: List<Int>) {

    init {
        require(numbers.size == LENGTH)
        require(numbers.toSet().size == LENGTH)
        require(numbers.all { it in MIN_NUMBER..MAX_NUMBER })
    }

    fun countBall(other: GameNumbers): Int {
        return numbers.withIndex().count { isBall(it.index, numbers, other.numbers) }
    }

    private fun isBall(index: Int, numbers1: List<Int>, numbers2: List<Int>): Boolean {
        for (i in numbers1.indices) {
            if (i != index && numbers1[i] == numbers2[i]) return true
        }
        return false
    }

    fun countStrike(other: GameNumbers): Int {
        return numbers.withIndex().count { isStrike(it.index, numbers, other.numbers) }
    }

    private fun isStrike(index: Int, numbers1: List<Int>, numbers2: List<Int>): Boolean {
        return numbers1[index] == numbers2[index]
    }

    companion object {
        const val LENGTH = 3
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 9
    }
}