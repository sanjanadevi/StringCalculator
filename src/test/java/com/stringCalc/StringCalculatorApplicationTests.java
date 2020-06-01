package com.stringCalc;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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
	
	@Test
	void returnNumberDelimitedByComma() {
		assertEquals(3, Calculator.add("1,2"));
	}
	
	@Test
	void returnSumOfMultipleNumbersSeperatedByComma() {
		assertEquals(6, Calculator.add("1,2,3"));
	}
	
	@Test
	void returnNumberDelimitedByCommaWithSpace() {
		assertEquals(3, Calculator.add("1, 2"));
	}
	
	@Test
	void acceptNewLineAsValidDelimiter() {
		assertEquals(6, Calculator.add("1,2\n3"));
	}
	
	@Test
	void shouldIgnoreNewLineAtTheEnd() {
		assertEquals(3, Calculator.add("1,2\n"));
	}
	
	@Test
	void acceptCustomDelimiterSyntax() {
		assertEquals(3, Calculator.add("//;\n1;2"));
	}
	
	@Test
	void throwExceptionOnNegativeNumber() {
		try {
			Calculator.add("-1,2,3");
			fail("Negative number found");
		}catch(Exception e) {
			
		}
	}

}
