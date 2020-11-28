package com.technicaltest.calculator.domain;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SubtractOperation implements Operation {
    @Override
    public BigDecimal calculate(BigDecimal number1, BigDecimal number2) {
        return number1.subtract(number2);
    }
}
