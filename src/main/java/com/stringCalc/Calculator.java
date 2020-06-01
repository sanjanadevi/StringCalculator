package com.stringCalc;

import java.util.Arrays;

public class Calculator {

	public static Integer add(String integer) {
		// TODO Auto-generated method stub
		if (integer.isEmpty())
			return 0;
		else if (integer.contains(",")) {
			String[] numbers = integer.split(",");
			return sumOfStringNumbers(numbers);
		} else
			return Integer.parseInt(integer);
	}

	private static int sumOfStringNumbers(String[] numbers) {
		return Arrays.stream(numbers).mapToInt(Integer::valueOf).sum();
	}

}
