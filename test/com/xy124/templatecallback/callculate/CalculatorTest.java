package com.xy124.templatecallback.callculate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    Calculator calculator;
    String numFilePath;

    @BeforeEach
    void setUp() {
        this.calculator = new Calculator();
        this.numFilePath = getClass().getResource("numbers.txt").getPath();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calcSumWithTemplate() throws IOException {
        assertThat(calculator.calcSumWithTemplate(this.numFilePath)).isEqualTo(10);
    }

    @Test
    void 곱연산_콜백_테스트() throws IOException {
        assertThat(calculator.calcMultiWithTemplate(this.numFilePath)).isEqualTo(25);
    }
}