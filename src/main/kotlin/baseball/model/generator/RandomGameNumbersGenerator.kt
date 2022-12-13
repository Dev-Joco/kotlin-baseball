package baseball.model.generator

import camp.nextstep.edu.missionutils.Randoms

class RandomGameNumbersGenerator : GameNumberGenerator {

    override fun generate(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(
            NumberList.MIN_NUMBER,
            NumberList.MAX_NUMBER,
            NumberList.LENGTH,
        )
    }
}