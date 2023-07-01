package org.example;

import org.example.calculate.Calculator;
import org.example.calculate.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
/**
 * 객체지향
 * - 적절한 객체에게 적절한 책임을 할당하여 서로 메시지를 주고 받으며 협력하도록 하는 것
 * - 점점 증가하는 sw 복잡도를 낮추기 위해 객체지향 패러다임 대두
 * - 클래스가 아닌 객체에 초점을 맞추는 것
 * - 객체들에게 얼마나 적잘한 역할과 책임을 할당하는지
 */

/**
 * 절차지향 vs 객체지향
 * - 책임이 한곳에 집중: 절차지향
 * - 책임이 여러 객체로 적절히 분산: 객체지향
 */

/**
 * 유지보수 증가
 * 높은 응집도: 비슷한 성격끼리는 모아놓기(어떠한 변경이 생겼을 때 특정 한 부분만 수정)
 * 낮은 결합도: 다른 성격끼리는 분리(어떠한 변화가 생겼을 때 다른 곳에는 영형을 주지 않음)
 */

/**
 * 객체지향 4가지 특징
 * 1. 추상화(Abstraction)
 * 2. 다형성(Polymorphism)
 * 3. 캡슐화(Encapsulation)
 * 4. 상속(Inheritance)
 */

/**
 * 객체지향의 5가지 설계 원칙(SOLID)
 * 1. SRP(단일 책임의 원칙)
 * 2. OCP(개방 폐쇄의 원칙): 기존 코드를 변경하지 않고 기능을 추가할 수 있어야 함.
 * 3. LSP(리스코프 치환의 원칙): 상위 타입의 객체를 하위타입의 객체로 치환해도 동작에 이상이 없어야 함.
 * 4. ISP(인터페이스 분리의 원칙): 많은 기능을 가진 인터페이스를 작은 단위의 인터페이스로
 * 5. DIP(의존성 역전의 원칙): 변경이 일어나지 않는 부분에 의존
 */


/**
 * 요구사항
 * 간단한 사칙연산을 할 수 있다.
 * 양수로만 계산할 수 있다.
 * 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.
 * MVC(Model-View-Controller)패턴 기반으로 구현한다.
 */

public class CalculatorTest {

    // 1 + 2 ----> Calculator
    //   3   <----
    @DisplayName("덧셈 연산을 수행한다.")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calculateTest(int operand1, String operator, int operand2, int result) {

        int calculateResult = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        assertThat(calculateResult).isEqualTo(result);
    }

    private static Stream<Arguments> formulaAndResult(){
        return Stream.of(
                arguments(1, "+", 2, 3),
                arguments(1, "-",2, -1),
                arguments(4, "*", 2, 8),
                arguments(4, "/", 2, 2)
        );
    }

    /**
     * PositiveNumber 객체를 통해 0을 받을 수 없기 때문에 의미가 없음
    @DisplayName("나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.")
    @Test
    void calculateExceptionTest(){
        assertThatCode(()->Calculator.calculate(new PositiveNumber(10), "/", new PositiveNumber(0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로는 나눌 수 없습니다.");
    }
    */
}
