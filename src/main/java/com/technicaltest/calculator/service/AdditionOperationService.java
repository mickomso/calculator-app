package com.technicaltest.calculator.service;

import com.technicaltest.calculator.domain.AdditionOperation;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

@Service
public class AdditionOperationService implements OperationService {

    private AdditionOperation additionOperation;

    public AdditionOperationService(AdditionOperation additionOperation) {
        this.additionOperation = additionOperation;
    }

    @Override
    public Number calculateResult(String number1, String number2) throws NumberFormatException {
        // Checks the correct numeric format
        Number parsedNumber1 = null;
        Number parsedNumber2 = null;

        try {
            parsedNumber1 = parseToNumericalValue(number1);
            parsedNumber2 = parseToNumericalValue(number2);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(e.getMessage());
        }

        // Calls the calculation service
        return additionOperation.calculate(parsedNumber1,parsedNumber2);
    }

    @Override
    public Number parseToNumericalValue(String number) throws NumberFormatException {
        return NumberUtils.createNumber(number);
    }
}