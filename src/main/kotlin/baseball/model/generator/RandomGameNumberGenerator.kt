package baseball.model.generator

import baseball.model.data.GameNumbers
import camp.nextstep.edu.missionutils.Randoms

class RandomGameNumberGenerator : GameNumberGenerator {

    override fun generate(): Int {
        return Randoms.pickNumberInRange(
            GameNumbers.MIN_NUMBER,
            GameNumbers.MAX_NUMBER,
        )
    }
}