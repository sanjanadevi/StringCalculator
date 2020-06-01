package com.stringCalc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class StringCalculatorApplicationTests {

	@Test
	void returnZeroOnEmptyString() {
		assertEquals(0, Calculator.add(""));
	}
	
	@Test
	void returnNumberOnNumberInput() {
		assertEquals(6, Calculator.add("6"));
	}

}
