package com.technicaltest.calculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller with the API Rest
 */
@RequestMapping("/api/v1/calculator")
public interface CalculatorController {

    /**
     * Adds two numbers of type: Integer, Float and/or Double
     * @param number1
     * @param number2
     * @return the result of adding two numbers
     * @throws NumberFormatException
     */
    @RequestMapping(method = RequestMethod.GET, value = "/addition")
    public ResponseEntity<Number> addNumbers(@RequestParam("number1") String number1, @RequestParam("number2") String number2) throws NumberFormatException;

    /**
     * Subtracts two numbers of type: Integer, Float and/or Double
     * @param number1
     * @param number2
     * @return the result of subtracting two numbers
     * @throws NumberFormatException
     */
    @RequestMapping(method = RequestMethod.GET, value = "/subtract")
    public ResponseEntity<Number> subtractNumbers(@RequestParam("number1") String number1, @RequestParam("number2") String number2) throws NumberFormatException;
}
