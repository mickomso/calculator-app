package com.technicaltest.calculator;

import com.technicaltest.calculator.service.AdditionOperationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
		String number1 = "5";
		String number2 = "4";
		Integer result = (Integer)additionOperationService.calculateResult(number1, number2);
		assertEquals(9,result,0);
	}

	@Test
	@DisplayName("Addition operation with Float types")
	public void testAdditionOperationWithFloatTypes() throws NumberFormatException {
		String number1 = "5.90";
		String number2 = "4.287";
		Float result = (float) additionOperationService.calculateResult(number1, number2);
		assertEquals(result, 10.187, 0.000001);
	}

	@Test
	@DisplayName("Addition operation with Double types")
	public void testAdditionOperationWithDoubleTypes() throws NumberFormatException {
		String number1 = "4.9e-324";
		String number2 = "2e-324";
		Double result = (double) additionOperationService.calculateResult(number1, number2);
		assertEquals(result, 6.9e-324, 0.000001);
	}

	@Test
	@DisplayName("Addition operation with different number types")
	public void testAdditionOperationWithDifferentNumberTypes() {
		String number1 = "5";
		String number2 = "6.9e-324";
		Double result = (double) additionOperationService.calculateResult(number1, number2);
		assertEquals(result, 5.0, 0.000001);
	}

	@DisplayName("Addition operation with not correct types")
	@Test
	public void testAdditionOperationWithNotCorrectTypes() {
		String number1 = "6";
		String number2 = "abc";
		Number result = null;
		try {
			result = (Number) additionOperationService.calculateResult(number1,number2);
		} catch (Exception e) {
			assertEquals("abc is not a valid number.", e.getMessage(), () -> "Should throw Exception");
		}
	}

	@DisplayName("Parse string to numerical value using Apache commons library")
	@Test
	public void testParseToNumericalValue() {
		String integerString = "5";
		Integer integerNumber = (Integer) additionOperationService.parseToNumericalValue(integerString);

		String floatString = "10.67F";
		Float floatNumber = (Float) additionOperationService.parseToNumericalValue(floatString);

		String doubleString = "4.9e-324";
		Double doubleNumber = (Double) additionOperationService.parseToNumericalValue(doubleString);

		assertAll(
				() -> assertEquals(integerNumber, Integer.parseInt(integerString)),
				() -> assertEquals(floatNumber, Float.parseFloat(floatString)),
				() -> assertEquals(doubleNumber, Double.parseDouble(doubleString))
		);
	}
}
