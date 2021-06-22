package com.github.benjamineckstein.calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void calculate() {
        double calculate = Calculator.calculate("0");
        assertEquals(0,calculate);
    }
}