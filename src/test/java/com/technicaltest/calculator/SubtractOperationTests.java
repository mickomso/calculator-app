package com.technicaltest.calculator;

import com.technicaltest.calculator.service.SubtractOperationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("<== Subtract Operation Tests ==>")
@SpringBootTest
public class SubtractOperationTests {

    @Autowired
    private SubtractOperationService subtractOperationService;

    @Test
    @DisplayName("Loads operator service context")
    public void contextLoads() {
        assertNotNull(subtractOperationService);
    }

    @Test
    @DisplayName("Subtract operation with Integer types")
    public void testSubtractOperationWithIntegerTypes() {
        BigDecimal number1 = new BigDecimal(5);
        BigDecimal number2 = new BigDecimal(4);
        BigDecimal result = subtractOperationService.calculateResult(number1, number2);
        assertEquals(new BigDecimal(1),result);
    }

    @Test
    @DisplayName("Subtract operation with Float types")
    public void testSubtractOperationWithFloatTypes() throws NumberFormatException {
        BigDecimal number1 = new BigDecimal(5.90);
        BigDecimal number2 = new BigDecimal(4.287);
        BigDecimal result = subtractOperationService.calculateResult(number1, number2);
        assertEquals(new BigDecimal(1.613).floatValue(), result.floatValue(), 0.000001);
    }

    @Test
    @DisplayName("Subtract operation with Double types")
    public void testSubtractOperationWithDoubleTypes() throws NumberFormatException {
        BigDecimal number1 = new BigDecimal(4.9e-324);
        BigDecimal number2 = new BigDecimal(3.2e-324);
        BigDecimal result = subtractOperationService.calculateResult(number1, number2);
        assertEquals(new BigDecimal(0).doubleValue(), result.doubleValue(), 0.000001);
    }

    @Test
    @DisplayName("Subtract operation with different number types")
    public void testSubtractOperationWithDifferentNumberTypes() {
        BigDecimal number1 = new BigDecimal(5);
        BigDecimal number2 = new BigDecimal(6.9e-324);
        BigDecimal result = subtractOperationService.calculateResult(number1, number2);
        assertEquals(new BigDecimal(5).doubleValue(), result.doubleValue(), 0.000001);
    }
}
