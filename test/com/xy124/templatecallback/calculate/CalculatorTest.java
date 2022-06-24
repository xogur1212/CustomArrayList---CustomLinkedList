package com.xy124.templatecallback.calculate;

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
    void calcSumWithNormalTemplate() throws IOException {
        assertThat(calculator.calcSumWithTemplate(this.numFilePath)).isEqualTo(10);
    }

    @Test
    void calcMultiWithNormalTemplate() throws IOException {
        assertThat(calculator.calcMultiWithTemplate(this.numFilePath)).isEqualTo(25);
    }

    @Test
    void lineCallback_합연산_테스트() throws IOException {
        assertThat(calculator.calcSumWithLineCallback(this.numFilePath)).isEqualTo(10);
    }

    @Test
    void lineCallback_곱연산_테스트() throws IOException {
        assertThat(calculator.calcMultiWithLineCallback(this.numFilePath)).isEqualTo(25);
    }


}