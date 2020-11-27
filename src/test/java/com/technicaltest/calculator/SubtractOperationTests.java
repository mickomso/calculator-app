package com.technicaltest.calculator;


import com.technicaltest.calculator.service.SubtractOperationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("<== Subtract Operation Tests ==>")
@SpringBootTest
public class SubtractOperationTests {

    @Autowired
    private SubtractOperationService substractOperationService;

    @Test
    @DisplayName("Loads operator service context")
    public void contextLoads() {
        assertNotNull(substractOperationService);
    }

    @Test
    @DisplayName("Subtract operation with Integer types")
    public void testSubtractOperationWithIntegerTypes() throws NumberFormatException {
        String number1 = "5";
        String number2 = "4";
        Integer result = (Integer) substractOperationService.calculateResult(number1, number2);
        assertEquals(1, result, 0);
    }

    @Test
    @DisplayName("Subtract operation with Double types")
    public void testSubtractOperationWithDoubleTypes() throws NumberFormatException {
        String number1 = "4.9e-324";
        String number2 = "2e-324";
        Double result = (double) substractOperationService.calculateResult(number1, number2);
        assertEquals(result, 2.9e-324, 0.000001);
    }

    @Test
    @DisplayName("Subtract operation with different number types")
    public void testSubtractOperationWithDifferentNumberTypes() {
        String number1 = "5";
        String number2 = "6.9e-324";
        Double result = (double) substractOperationService.calculateResult(number1, number2);
        assertEquals(result, 5.0, 0.000001);
    }

    @DisplayName("Subtract operation with not correct types")
    @Test
    public void testSubtractOperationWithNotCorrectTypes() {
        String number1 = "6";
        String number2 = "abc";
        Number result = null;
        try {
            result = (Number) substractOperationService.calculateResult(number1,number2);
        } catch (Exception e) {
            assertEquals("abc is not a valid number.", e.getMessage(), () -> "Should throw Exception");
        }
    }

    @DisplayName("Parse string to numerical value using Apache commons library")
    @Test
    public void testParseToNumericalValue() {
        String integerString = "5";
        Integer integerNumber = (Integer) substractOperationService.parseToNumericalValue(integerString);

        String floatString = "10.67F";
        Float floatNumber = (Float) substractOperationService.parseToNumericalValue(floatString);

        String doubleString = "4.9e-324";
        Double doubleNumber = (Double) substractOperationService.parseToNumericalValue(doubleString);

        assertAll(
                () -> assertEquals(Integer.parseInt(integerString), integerNumber),
                () -> assertEquals(Float.parseFloat(floatString), floatNumber),
                () -> assertEquals(Double.parseDouble(doubleString), doubleNumber)
        );
    }
}
