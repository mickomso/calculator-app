package com.technicaltest.calculator.domain;

/**
 * Operation model interface
 */
public interface Operation {

    /**
     * Calculates the corresponding operation checking the number type and reject the non admitted types as short, long...
     * @param number1
     * @param number2
     * @return a number typed result
     * @throws NumberFormatException
     */
    public Number calculate(Number number1, Number number2) throws NumberFormatException;
}
