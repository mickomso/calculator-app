package com.technicaltest.calculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * Controller with the API Rest
 */
@RequestMapping("/api/v1/calculator")
public interface CalculatorController {

    /**
     * Adds two numbers
     * @param number1
     * @param number2
     * @return the result of adding two numbers
     */
    @RequestMapping(method = RequestMethod.GET, value = "/addition")
    public ResponseEntity<BigDecimal> addNumbers(@RequestParam("number1") BigDecimal number1, @RequestParam("number2") BigDecimal number2);

    /**
     * Subtracts two numbers
     * @param number1
     * @param number2
     * @return the result of subtracting two numbers
     */
    @RequestMapping(method = RequestMethod.GET, value = "/subtract")
    public ResponseEntity<BigDecimal> subtractNumbers(@RequestParam("number1") BigDecimal number1, @RequestParam("number2") BigDecimal number2);
}
