package com.technicaltest.calculator.service;

import com.technicaltest.calculator.domain.SubtractOperation;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SubtractOperationService implements OperationService {

    private SubtractOperation subtractOperation;

    public SubtractOperationService(SubtractOperation subtractOperation) {
        this.subtractOperation = subtractOperation;
    }

    @Override
    public BigDecimal calculateResult(BigDecimal number1, BigDecimal number2) {
        return subtractOperation.calculate(number1,number2);
    }
}
