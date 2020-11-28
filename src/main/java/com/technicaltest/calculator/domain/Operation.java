package com.technicaltest.calculator.domain;

import java.math.BigDecimal;

/**
 * Operation model interface
 */
public interface Operation {

    /**
     * Calculates the corresponding operation
     * @param number1
     * @param number2
     * @return a number typed result
     * @throws NumberFormatException
     */
    public BigDecimal calculate(BigDecimal number1, BigDecimal number2);
}
