package com.stringCalc;

import java.util.Arrays;

public class Calculator {

	public static Integer add(String integer) {
		if (integer.isEmpty())
			return 0;
		else if (integer.contains(",")) {
			String[] numbers = extractInteger(integer);
			return sumOfStringNumbers(numbers);
		} else
			return Integer.parseInt(integer);
	}

	private static String[] extractInteger(String integer) {
		return integer.split(",|\n");
	}

	private static int sumOfStringNumbers(String[] numbers) {
		return Arrays.stream(numbers).map(e -> e.trim()).mapToInt(Integer::valueOf).sum();
	}

}
