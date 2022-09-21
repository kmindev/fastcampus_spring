package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryStringTest {

    @Test
    void createTest() {
        QueryString queryString = new QueryString("operand1=11", "11"); //key - value 가 한 쌍인 객체

        assertThat(queryString).isNotNull();
    }
}
