package org.example.calculate;

public class DivisionOperator implements NewArithmeticOperator{
    @Override
    public boolean supports(String operator) {
        return "%2F".equals(operator);
    }  // URL 인코딩

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
        return operand1.toInt() / operand2.toInt();
    }
}
