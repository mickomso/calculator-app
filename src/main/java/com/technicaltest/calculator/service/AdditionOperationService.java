package com.technicaltest.calculator.service;

import com.technicaltest.calculator.domain.AdditionOperation;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AdditionOperationService implements OperationService {

    private AdditionOperation additionOperation;

    public AdditionOperationService(AdditionOperation additionOperation) {
        this.additionOperation = additionOperation;
    }

    @Override
    public BigDecimal calculateResult(BigDecimal number1, BigDecimal number2) {
        return additionOperation.calculate(number1,number2);
    }
}
