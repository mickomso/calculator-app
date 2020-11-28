package com.technicaltest.calculator.controller;

import com.technicaltest.calculator.service.AdditionOperationService;
import com.technicaltest.calculator.service.SubtractOperationService;
import com.technicaltest.calculator.util.TracerLogger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class DefaultCalculatorController implements CalculatorController {

    private TracerLogger log;
    private AdditionOperationService additionOperationService;
    private SubtractOperationService subtractOperationService;

    public DefaultCalculatorController(AdditionOperationService additionOperationService, SubtractOperationService subtractOperationService, TracerLogger log) {
        this.additionOperationService = additionOperationService;
        this.subtractOperationService = subtractOperationService;
        this.log = log;
    }

    public ResponseEntity<BigDecimal> addNumbers(BigDecimal number1, BigDecimal number2) {
        BigDecimal number = additionOperationService.calculateResult(number1, number2);
        log.trace("Result for addNumbers(" + number1 + ", " + number2 + ") => " + number);
        return ResponseEntity.ok(number);
    }

    public ResponseEntity<BigDecimal> subtractNumbers(BigDecimal number1, BigDecimal number2) {
        BigDecimal number = subtractOperationService.calculateResult(number1, number2);
        log.trace("Result for subtractNumbers(" + number1 + ", " + number2 + ") => " + number);
        return ResponseEntity.ok(number);
    }
}