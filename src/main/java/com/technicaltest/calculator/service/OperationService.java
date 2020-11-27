package com.technicaltest.calculator.service;

/**
 * Service layer with the business logic
 */
public interface OperationService {

    /**
     * Checks the number types and calls the calculation method
     * @param number1
     * @param number2
     * @return the result of the calculation
     * @throws NumberFormatException
     */
    public Number calculateResult(String number1, String number2) throws NumberFormatException;

    /**
     * Uses the Apache commons library in order to get the correct Number subtype from a String parameter
     * @param number
     * @return a Number type result
     * @throws NumberFormatException
     */
    public Number parseToNumericalValue(String number) throws NumberFormatException;
}
