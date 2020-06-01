package com.stringCalc;

public class Calculator {

	public static Integer add(String integer) {
		// TODO Auto-generated method stub
		if (integer.isEmpty())
			return 0;
		else if (integer.contains(",")) {
			String[] numbers = integer.split(",");
			return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
		} else
			return Integer.parseInt(integer);
	}

}
