package com.stringCalc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static Integer add(String integer) throws Exception {
		if (integer.isEmpty())
			return 0;
		else if (integer.contains(",") || integer.contains("//")) {
			String[] numbers = extractInteger(integer);
			List<Integer> intArr = checkIfIntegerIsLessThanZero(numbers);
			if(intArr.size() > 0)
				throw new Exception();
			return sumOfStringNumbers(numbers);
		} else
			return Integer.parseInt(integer);
	}

	private static List<Integer> checkIfIntegerIsLessThanZero(String[] numbers) {
		List<Integer> negativeNumberList = new ArrayList<Integer>();
		for(String numb: numbers) {
			if(Integer.valueOf(numb.trim()) < 0)
				negativeNumberList.add(Integer.valueOf(numb.trim()));
		}
		return negativeNumberList;
	}

	private static String[] extractInteger(String integer) {
		if(integer.startsWith("//")) {
			return splitUsingCustomDelimiter(integer);
		}
		return splitUsingCommaNewline(integer);
	}

	private static String[] splitUsingCommaNewline(String integer) {
		return integer.split(",|\n");
	}

	private static String[] splitUsingCustomDelimiter(String integer) {
		Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(integer);
		matcher.matches();
		String delimiter = matcher.group(1);
		String numbers = matcher.group(2);
		return numbers.split(delimiter);
	}

	private static int sumOfStringNumbers(String[] numbers) {
		return Arrays.stream(numbers).map(e -> e.trim()).mapToInt(Integer::valueOf).sum();
	}

}
