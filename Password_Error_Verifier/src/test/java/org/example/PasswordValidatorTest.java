package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

/**
 * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
 * 비밀번호는 8자 미만 또는 12자 초과인 경우 IllegelArgumentException 예외를 발생
 * NBSP 경계조건에 대해 테스트 코드를 작성해야 한다.
 */

public class PasswordValidatorTest {

    @DisplayName("비밀번호가 최소 8자 이상, 12자 이하면 예외가 발생하지 않는다")
    @Test   //디렉토리, 패키지, 클래스 등 생성 목록 보기 Alt + Insert
    void validatePasswordTest() {
        assertThatCode(() -> PasswordValidator.validate("serverwizard"))
                .doesNotThrowAnyException();
    }

    //경계값 테스트
    @DisplayName("비밀번호가 8자 미만 또는 12자 초과하는 경우 IllegalArgumentException 예외가 발생한다.")
    @ParameterizedTest   //의존성 추가
    @ValueSource(strings = {"aabbcce", "aabbccddeeffg"})
    void validatePasswordTest2(String password) {

        assertThatCode(() -> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 8자 이상 12자 이하여야 한다.");
    }
}
