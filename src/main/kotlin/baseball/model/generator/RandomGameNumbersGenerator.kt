package baseball.model.generator

import baseball.model.data.GameNumbers
import camp.nextstep.edu.missionutils.Randoms

class RandomGameNumbersGenerator : GameNumberGenerator {

    override fun generate(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(
            GameNumbers.MIN_NUMBER,
            GameNumbers.MAX_NUMBER,
            GameNumbers.LENGTH,
        )
    }
}