package baseball

import baseball.view.strings.Command
import baseball.view.strings.GameCommand
import baseball.view.validator.InputValidator
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
                assertThat(InputValidator.validateBallNumbers(it)).isEqualTo(it)
            }
        }
        @Test
        fun `길이3, 중복X, not in (1~9)`() {
            throwIllegalArgumentException { InputValidator.validateBallNumbers("120") }
            throwIllegalArgumentException { InputValidator.validateBallNumbers("1x9") }
        }
        @Test
        fun `길이3, 중복O, in (1~9)`() {
            throwIllegalArgumentException { InputValidator.validateBallNumbers("121") }
        }
        @Test
        fun `길이3, 중복O, not in (1~9)`() {
            throwIllegalArgumentException { InputValidator.validateBallNumbers("101") }
            throwIllegalArgumentException { InputValidator.validateBallNumbers("x11") }
        }
        @Test
        fun `길이3미만, 중복X, in (1~9)`() {
            throwIllegalArgumentException { InputValidator.validateBallNumbers("12") }
        }
        @Test
        fun `길이3미만, 중복X, not in (1~9)`() {
            throwIllegalArgumentException { InputValidator.validateBallNumbers("02") }
            throwIllegalArgumentException { InputValidator.validateBallNumbers("1x") }
        }
        @Test
        fun `길이3미만, 중복O, in (1~9)`() {
            throwIllegalArgumentException { InputValidator.validateBallNumbers("11") }
        }
        @Test
        fun `길이3미만, 중복O, not in (1~9)`() {
            throwIllegalArgumentException { InputValidator.validateBallNumbers("11") }
            throwIllegalArgumentException { InputValidator.validateBallNumbers("xx") }
        }
        @Test
        fun `길이3초과, 중복X, in (1~9)`() {
            throwIllegalArgumentException { InputValidator.validateBallNumbers("1234") }
        }
        @Test
        fun `길이3초과, 중복X, not in (1~9)`() {
            throwIllegalArgumentException { InputValidator.validateBallNumbers("1230") }
            throwIllegalArgumentException { InputValidator.validateBallNumbers("1x34") }
        }
        @Test
        fun `길이3초과, 중복O, in (1~9)`() {
            throwIllegalArgumentException { InputValidator.validateBallNumbers("1232") }
        }
        @Test
        fun `길이3초과, 중복O, not in (1~9)`() {
            throwIllegalArgumentException { InputValidator.validateBallNumbers("1202") }
            throwIllegalArgumentException { InputValidator.validateBallNumbers("121x") }
        }
    }

    @Nested
    @DisplayName("재시작(1)/종료(2) 코드 테스트")
    inner class RestartOrFinishCode {

        @Test
        fun `올바른 코드`() {
            assertThat(InputValidator.validateGameCommand("1")).isEqualTo(GameCommand.RETRY)
            assertThat(InputValidator.validateGameCommand("2")).isEqualTo(GameCommand.FINISH)
        }

        @Test
        fun `잘못된 코드`() {
            throwIllegalArgumentException { InputValidator.validateGameCommand("0") }
            throwIllegalArgumentException { InputValidator.validateGameCommand("3") }
        }
    }

    private fun throwIllegalArgumentException(executable: () -> Unit) {
        assertSimpleTest { assertThrows<IllegalArgumentException>(executable) }
    }
}