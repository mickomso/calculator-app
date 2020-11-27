package com.technicaltest.calculator.service;

import com.technicaltest.calculator.domain.SubtractOperation;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

@Service
public class SubtractOperationService implements OperationService {

    private SubtractOperation subtractOperation;

    public SubtractOperationService(SubtractOperation subtractOperation) {
        this.subtractOperation = subtractOperation;
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
        return subtractOperation.calculate(parsedNumber1,parsedNumber2);
    }

    @Override
    public Number parseToNumericalValue(String number) throws NumberFormatException {
        return NumberUtils.createNumber(number);
    }

}
