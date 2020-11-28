package com.technicaltest.calculator.service;

import java.math.BigDecimal;

/**
 * Service layer with the business logic
 */
public interface OperationService {

    /**
     * Checks the number types and calls the calculation method
     * @param number1
     * @param number2
     * @return the result of the calculation
     */
    public BigDecimal calculateResult(BigDecimal number1, BigDecimal number2);
}
