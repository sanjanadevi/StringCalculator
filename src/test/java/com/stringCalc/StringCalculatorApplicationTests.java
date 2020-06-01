package com.stringCalc;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

//@SpringBootTest
class StringCalculatorApplicationTests {

	@Test
	void returnZeroOnEmptyString() throws Exception {
		assertEquals(0, Calculator.add(""));
	}
	
	@Test
	void returnNumberOnNumberInput() throws Exception {
		assertEquals(6, Calculator.add("6"));
	}
	
	@Test
	void returnNumberDelimitedByComma() throws Exception {
		assertEquals(3, Calculator.add("1,2"));
	}
	
	@Test
	void returnSumOfMultipleNumbersSeperatedByComma() throws Exception {
		assertEquals(6, Calculator.add("1,2,3"));
	}
	
	@Test
	void returnNumberDelimitedByCommaWithSpace() throws Exception {
		assertEquals(3, Calculator.add("1, 2"));
	}
	
	@Test
	void acceptNewLineAsValidDelimiter() throws Exception {
		assertEquals(6, Calculator.add("1,2\n3"));
	}
	
	@Test
	void shouldIgnoreNewLineAtTheEnd() throws Exception {
		assertEquals(3, Calculator.add("1,2\n"));
	}
	
	@Test
	void acceptCustomDelimiterSyntax() throws Exception {
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
	
	@Test
	void throwExceptionOnNegativeNumberWithNegativeNumbers() {
		try {
			Calculator.add("-1,-2,3");
		}catch(Exception e) {
			assertEquals("Negative number found: -1,-2", e.getMessage());
		}
	}

}
