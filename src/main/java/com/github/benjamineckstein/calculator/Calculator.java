package com.github.benjamineckstein.calculator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Calculator {

    /**
     * This methods takes in a string as input and needs to evaluate
     * this string as a math expression and return the correct calculation
     * "0"   --> 1
     * "1+1" --> 2
     * "2*2" --> 4
     * "2/4" --> 0.5
     * <p>
     * Supported operators are +, -, *, /, ()
     * Numbers can be formatted integers or doubles like 1.023,5501
     *
     * @param input is a math expression
     * @return
     */
    public static double calculate(String input) {

        if (Objects.isNull(input)) {
            input = "0";
        }

        List<String> mathExpressions = getMathExpressions(input);
        return calculateMathExpressions(mathExpressions);
    }

    public static double calculateMathExpressions(List<String> mathExpressions) {

        mathExpressions = new ArrayList<>(mathExpressions);

        double calculatedValue = Integer.parseInt(mathExpressions.remove(0));
        while (!mathExpressions.isEmpty()) {
            mathExpressions.remove(0);
            double nextValue = Integer.parseInt(mathExpressions.remove(0));
            calculatedValue = calculatedValue + nextValue;
        }
        return calculatedValue;
    }

    public static List<String> getMathExpressions(String input) {

        String[] sumParts = input.split("\\+");

        List<String> parts = new ArrayList<>();

        for (String sumPart : sumParts) {
            parts.add(sumPart);
            parts.add("+");
        }
        parts.remove(parts.size() - 1);
        return parts;
    }

}
