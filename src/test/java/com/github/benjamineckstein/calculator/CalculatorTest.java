package com.github.benjamineckstein.calculator;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class CalculatorTest {

    @Test
    void calculate() {
        double calculate = Calculator.calculate("0");
        assertThat(calculate).isEqualTo(0);
    }

    @Test
    void calculateNull() {
        double calculate = Calculator.calculate(null);
        assertThat(calculate).isEqualTo(0);
    }

    @Test
    void calculateSimpleNumberNotZero() {
        double calculate = Calculator.calculate("1");
        assertThat(calculate).isEqualTo(1);
    }

    @Test
    void calculateSimpleNumberNegativ() {
        double calculate = Calculator.calculate("-10");
        assertThat(calculate).isEqualTo(-10);
    }

    @Test
    void calculateSimpleAddition() {
        double calculate = Calculator.calculate("1+1");
        assertThat(calculate).isEqualTo(2);
    }


    @Test
    void getMathExpressions() {

        String input = "1";
        List<String> mathExpressions = Calculator.getMathExpressions(input);
        assertThat(mathExpressions).isNotNull().isNotEmpty().contains("1");
    }

    @Test
    void getMathExpressionsForASum() {
        String input = "1+1";
        List<String> mathExpressions = Calculator.getMathExpressions(input);
        assertThat(mathExpressions).containsExactly("1", "+", "1");
    }

    @Test
    void getMathExpressionsForABigSum() {
        String input = "20+90";
        List<String> mathExpressions = Calculator.getMathExpressions(input);
        assertThat(mathExpressions).containsExactly("20", "+", "90");
    }


    @Test
    void calculateMathExpressions() {
        //given
        List<String> expressions =List.of("20","+","90");

        //when
        double result = Calculator.calculateMathExpressions(expressions);

        //then
        assertThat(result).isEqualTo(110);
    }


}