package com.stringCalc;

public class Calculator {

	public static Integer add(String integer) {
		// TODO Auto-generated method stub
		if(integer.isEmpty())
			return 0;
		else
			return Integer.parseInt(integer);
	}

}
