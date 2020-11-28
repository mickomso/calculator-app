package com.technicaltest.calculator;

import com.technicaltest.calculator.service.AdditionOperationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("<== Addition Operation Tests ==>")
@SpringBootTest
public class AdditionOperationTests {

	@Autowired
	private AdditionOperationService additionOperationService;

	@Test
	@DisplayName("Loads operator service context")
	public void contextLoads() {
		assertNotNull(additionOperationService);
	}

	@Test
	@DisplayName("Addition operation with Integer types")
	public void testAdditionOperationWithIntegerTypes() {
		BigDecimal number1 = new BigDecimal(5);
		BigDecimal number2 = new BigDecimal(4);
		BigDecimal result = additionOperationService.calculateResult(number1, number2);
		assertEquals(new BigDecimal(9),result);
	}

	@Test
	@DisplayName("Addition operation with Float types")
	public void testAdditionOperationWithFloatTypes() throws NumberFormatException {
		BigDecimal number1 = new BigDecimal(5.90);
		BigDecimal number2 = new BigDecimal(4.287);
		BigDecimal result = additionOperationService.calculateResult(number1, number2);
		assertEquals(new BigDecimal(10.187).floatValue(), result.floatValue(), 0.000001);
	}

	@Test
	@DisplayName("Addition operation with Double types")
	public void testAdditionOperationWithDoubleTypes() throws NumberFormatException {
		BigDecimal number1 = new BigDecimal(4.9e-324);
		BigDecimal number2 = new BigDecimal(3e-324);
		BigDecimal result = additionOperationService.calculateResult(number1, number2);
		assertEquals(new BigDecimal(7.9e-324).doubleValue(), result.doubleValue(), 0.000001);
	}

	@Test
	@DisplayName("Addition operation with different number types")
	public void testAdditionOperationWithDifferentNumberTypes() {
		BigDecimal number1 = new BigDecimal(5);
		BigDecimal number2 = new BigDecimal(6.9e-324);
		BigDecimal result = additionOperationService.calculateResult(number1, number2);
		assertEquals(new BigDecimal(5).doubleValue(), result.doubleValue(), 0.000001);
	}
}
