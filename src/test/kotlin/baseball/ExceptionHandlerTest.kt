package baseball

import baseball.view.strings.Command
import baseball.view.strings.GameCommand
import baseball.view.validator.Validator
import baseball.view.strings.Message
import org.junit.jupiter.api.Test
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.assertThrows

private typealias GameCommand = Command.Game

class ExceptionHandlerTest {

    private val digits = List(9) { it + 1 }

    @Nested
    @DisplayName("숫자 입력 테스트")
    inner class InputNumberFormat {

        @RepeatedTest(10)
        fun `길이3, 중복X, in (1~9)`() {
            digits.shuffled().take(3).joinToString("").let {
                assertThat(Validator.validateNumberFormat(it)).isEqualTo(it)
            }
        }
        @Test
        fun `길이3, 중복X, not in (1~9)`() {
            throwIllegalArgumentException { Validator.validateNumberFormat("120") }
            throwIllegalArgumentException { Validator.validateNumberFormat("1x9") }
        }
        @Test
        fun `길이3, 중복O, in (1~9)`() {
            throwIllegalArgumentException { Validator.validateNumberFormat("121") }
        }
        @Test
        fun `길이3, 중복O, not in (1~9)`() {
            throwIllegalArgumentException { Validator.validateNumberFormat("101") }
            throwIllegalArgumentException { Validator.validateNumberFormat("x11") }
        }
        @Test
        fun `길이3미만, 중복X, in (1~9)`() {
            throwIllegalArgumentException { Validator.validateNumberFormat("12") }
        }
        @Test
        fun `길이3미만, 중복X, not in (1~9)`() {
            throwIllegalArgumentException { Validator.validateNumberFormat("02") }
            throwIllegalArgumentException { Validator.validateNumberFormat("1x") }
        }
        @Test
        fun `길이3미만, 중복O, in (1~9)`() {
            throwIllegalArgumentException { Validator.validateNumberFormat("11") }
        }
        @Test
        fun `길이3미만, 중복O, not in (1~9)`() {
            throwIllegalArgumentException { Validator.validateNumberFormat("11") }
            throwIllegalArgumentException { Validator.validateNumberFormat("xx") }
        }
        @Test
        fun `길이3초과, 중복X, in (1~9)`() {
            throwIllegalArgumentException { Validator.validateNumberFormat("1234") }
        }
        @Test
        fun `길이3초과, 중복X, not in (1~9)`() {
            throwIllegalArgumentException { Validator.validateNumberFormat("1230") }
            throwIllegalArgumentException { Validator.validateNumberFormat("1x34") }
        }
        @Test
        fun `길이3초과, 중복O, in (1~9)`() {
            throwIllegalArgumentException { Validator.validateNumberFormat("1232") }
        }
        @Test
        fun `길이3초과, 중복O, not in (1~9)`() {
            throwIllegalArgumentException { Validator.validateNumberFormat("1202") }
            throwIllegalArgumentException { Validator.validateNumberFormat("121x") }
        }
    }

    @Nested
    @DisplayName("재시작(1)/종료(2) 코드 테스트")
    inner class RestartOrFinishCode {

        @Test
        fun `올바른 코드`() {
            assertThat(Validator.validateGameCommand("1")).isEqualTo(GameCommand.RESTART)
            assertThat(Validator.validateGameCommand("2")).isEqualTo(GameCommand.FINISH)
        }

        @Test
        fun `잘못된 코드`() {
            throwIllegalArgumentException { Validator.validateGameCommand("0") }
            throwIllegalArgumentException { Validator.validateGameCommand("3") }
        }
    }

    private fun throwIllegalArgumentException(executable: () -> Unit) {
        assertSimpleTest { assertThrows<IllegalArgumentException>(executable) }
    }
}