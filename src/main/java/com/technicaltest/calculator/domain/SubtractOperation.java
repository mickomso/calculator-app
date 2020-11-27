package com.technicaltest.calculator.domain;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SubtractOperation implements Operation {
    @Override
    public Number calculate(Number number1, Number number2) throws NumberFormatException {        {

            // Fixing the conversion from BigDecimal to Double,
            // when Number to BigDecimal type number conversion happens.
            if (number1 instanceof BigDecimal) {
                number1 = number1.doubleValue();
            }
            if (number2 instanceof BigDecimal) {
                number2 = number2.doubleValue();
            }

            // Checking the parse operation between Integer, Float and Double
            if (number1 instanceof Integer && number2 instanceof Integer) {
                return number1.intValue() - number2.intValue();
            } else if (number1 instanceof Float && number2 instanceof Float) {
                return number1.floatValue() - number2.floatValue();
            } else if (number1 instanceof Double && number2 instanceof Double) {
                return number1.doubleValue() - number2.doubleValue();
            } else if (number1 instanceof Integer && number2 instanceof Float) {
                return number1.intValue() - number2.floatValue();
            } else if (number1 instanceof Integer && number2 instanceof Double) {
                return number1.intValue() - number2.doubleValue();
            } else if (number1 instanceof Float && number2 instanceof Integer) {
                return number1.floatValue() - number2.intValue();
            } else if (number1 instanceof Float && number2 instanceof Double) {
                return number1.floatValue() - number2.doubleValue();
            } else if (number1 instanceof Double && number2 instanceof Integer) {
                return number1.doubleValue() - number2.intValue();
            } else if (number1 instanceof Double && number2 instanceof Float) {
                return number1.doubleValue() - number2.floatValue();
            } else {
                throw new NumberFormatException("At least one of the parameters is not a valid number");
            }
        }
    }
}
